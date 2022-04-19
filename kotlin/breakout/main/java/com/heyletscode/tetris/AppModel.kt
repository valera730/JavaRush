package com.heyletscode.tetris

import android.graphics.Point
import com.heyletscode.tetris.constants.CellConstants
import com.heyletscode.tetris.constants.FieldConstants
//import com.heyletscode.tetris.helpers.array2dOfByte
import com.heyletscode.tetris.helpers.array2dOfByte
import com.heyletscode.tetris.models.Block
import com.heyletscode.tetris.storage.AppPreferences

//import com.heyletscode.tetris.storage.AppPreferences
//import com.heyletscode.tetris.models

class AppModel {
    var score: Int = 0      //текущий счет
    private var preferences: AppPreferences? =
        null     //содержит объект AppPreferences для доступа к файлу SharedPreferences

    var currentBlock: Block? = null     //текущий блок трансляции через игровое поле
    var currentState: String = Statuses.AWAITING_START.name     //состояние игры

    private var field: Array<ByteArray> = array2dOfByte(    //двумерный массив игрового поля
        FieldConstants.ROW_COUNT.value,
        FieldConstants.COLUMN_COUNT.value
    )

    //устанавливает свойство предпочтений для AppModel для передачи экземпляра класса AppPreferences в виде аргумента этой функции
    fun setPreferences(preferences: AppPreferences?) {
        this.preferences = preferences
    }

    //возвращает состояние ячейки, имеющейся в указанной позиции столбца в двумерном массиве поля
    fun getCellStatus(row: Int, column: Int): Byte? {
        return field[row][column];
    }

    //устанавливает состояние имеющейся в поле ячейки равным указанному байту
    private fun setCellStatus(row: Int, column: Int, status: Byte?) {
        if (status != null) {
            field[row][column] = status
        }
    }

    //функции для проверки состояния игры в данный момент
    fun isGameOver(): Boolean {
        return currentState == Statuses.OVER.name
    }

    fun isGameActive(): Boolean {
        return currentState == Statuses.ACTIVE.name
    }

    fun isGameAwaitingStart(): Boolean {
        return currentState == Statuses.AWAITING_START.name
    }

    //прибавить очков
    private fun boostScore() {
        score += 10
        if (score > preferences?.getHighScore() as Int)
            preferences?.saveHighScore(score)
    }

    //создаёт новый экземпляр блока и устанавливает значение currentBlock равным созданному экземпляру
    private fun generateNextBlock() {
        currentBlock = Block.createBlock()
    }

    enum class Statuses {
        AWAITING_START, //состояние игры до запуска
        ACTIVE,         //игровой процесс выполняется
        INACTIVE,       //игровой процесс не выполняется
        OVER            //игра завершена
    }

    //представление направлений движения блока
    enum class Motions {
        LEFT, RIGHT, DOWN, ROTATE
    }

    //проверка допустимости поступательного движения тетрамино в игровом поле на основе набора условий
    //возвращает true, если трансляция корректна
    private fun validTranslation(position: Point, shape: Array<ByteArray>): Boolean {
        return if (position.y < 0 || position.x < 0) {
            false
        } else if (position.y + shape.size > FieldConstants.ROW_COUNT.value) {
            false
        } else if (position.x + shape[0].size > FieldConstants.COLUMN_COUNT.value) {
            false
        } else {
            for (i in 0 until shape.size) {
                for (j in 0 until shape[i].size) {
                    val y = position.y + i
                    val x = position.x + j
                    if (CellConstants.EMPTY.value != shape[i][j] && CellConstants.EMPTY.value != field[y][x]) {
                        return false
                    }
                }
            }
            true
        }
    }

    private fun moveValid(position: Point, frameNumber: Int?): Boolean {
        val shape: Array<ByteArray>? = currentBlock?.getShape(frameNumber as Int)

        return validTranslation(position, shape as Array<ByteArray>)
    }

    //генерирует обновление поля; обновление поля определяется действием action
    fun generateField(action: String) {
        if (isGameActive()) {
            resetField()
            var frameNumber: Int? = currentBlock?.frameNumber
            val coordinate: Point? = Point()
            coordinate?.x = currentBlock?.position?.x
            coordinate?.y = currentBlock?.position?.y

            when (action) {
                Motions.LEFT.name -> {
                    coordinate?.x = currentBlock?.position?.x?.minus(1)
                }
                Motions.RIGHT.name -> {
                    coordinate?.x = currentBlock?.position?.x?.plus(1)
                }
                Motions.DOWN.name -> {
                    coordinate?.y = currentBlock?.position?.y?.plus(1)
                }
                Motions.ROTATE.name -> {
                    frameNumber = frameNumber?.plus(1)
                    if (frameNumber != null) {
                        if (frameNumber >= currentBlock?.frameCount as Int) {
                            frameNumber = 0
                        }
                    }
                }
            }

            if (!moveValid(coordinate as Point, frameNumber)) {
                translateBlock(currentBlock?.position as Point, currentBlock?.frameNumber as Int)
                if (Motions.DOWN.name == action) {
                    boostScore()
                    persistCellData()
                    assessField()
                    generateNextBlock()
                    if (!blockAdditionPossible()) {
                        currentState = Statuses.OVER.name
                        currentBlock = null
                        resetField(false)
                    }
                }
            }
        } else {
            if (frameNumber != null) {
                translateBlock(coordinate, frameNumber)
                currentBlock?.setState(frameNumber, coordinate)
            }
        }
    }

    private fun resetField(ephemeralCellsOnly: Boolean = true) {
        for (i in 0 until FieldConstants.ROW_COUNT.value) {
            (0 until FieldConstants.COLUMN_COUNT.value)
                .filter(!ephemeralCellsOnly || field[i][it] == CellConstants.EPHEMERAL.value)
                .forEach(field[i][it] = CellConstants.EMPTY.value)
        }
    }

    //сохранение состояния всех ячеек поля
    private fun persistCellData() {
        for (i in 0 until field.size) {
            for (j in 0 until field[i].size) {
                var status = getCellStatus(i, j)
                if (status == CellConstants.EPHEMERAL.value) {
                    status = currentBlock?.staticValue
                    setCellStatus(i, j, status)
                }
            }
        }
    }

    //построчное сканирование строк поля и проверки заполняемости находящихся в строках ячеек
    private fun assessField() {
        for (i in 0 until field.size) {
            var emptyCells = 0;
            for (j in 0 until field[i].size) {
                val status = getCellStatus(i, j)
                val isEmpty = CellConstants.EMPTY.value == status
                if (isEmpty)
                    emptyCells++
                if (emptyCells == 0)
                    shiftRows(i)
            }
        }
    }

    private fun translateBlock(position: Point, frameNumber: Int) {
        synchronized(field) {
            val shape: Array<ByteArray>? = currentBlock?.getShape(frameNumber)
            if (shape != null) {
                for (i in shape.indices) {
                    for (j in 0 until shape[i].size) {
                        val y = position.y + i
                        val x = position.x + i
                        if (CellConstants.EMPTY.value != shape[i][j]) {
                            field[y][x] = shape[i][j]
                        }
                    }
                }
            }
        }
    }

    //проверка, что поле ещё не заполнено, а блок может перемещаться в поле
    private fun blockAdditionPossible(): Boolean {
        if (!moveValid(currentBlock?.position as Point, currentBlock?.frameNumber)) {
            return false
        }
        return true
    }

    //сдвиг строк
    private fun shiftRows(nToRow: Int) {
        if (nToRow > 0) {
            for (j in nToRow - 1 downTo 0) {
                for (m in 0 until field[j].size) {
                    setCellStatus(j + 1, m, getCellStatus(j, m))
                }
            }
        }

        for (j in 0 until field[0].size) {
            setCellStatus(0, j, CellConstants.EMPTY.value)
        }
    }

    fun startGame() {
        if (!isGameActive()) {
            currentState = Statuses.ACTIVE.name
            generateNextBlock()
        }
    }

    fun restartGame() {
        resetModel()
        startGame()
    }

    fun endGame() {
        score = 0
        currentState = AppModel.Statuses.OVER.name
    }

    private fun resetModel() {
        resetField(false)
        currentState = Statuses.AWAITING_START.name
        score = 0
    }
}