package com.heyletscode.tetris.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Message
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.annotation.Dimension
import com.heyletscode.tetris.AppModel
import com.heyletscode.tetris.GameActivity
import com.heyletscode.tetris.constants.CellConstants
import com.heyletscode.tetris.constants.FieldConstants
import com.heyletscode.tetris.models.Block
import java.util.logging.Handler

class TetrisView : View {
    private val paint = Paint()
    private var lastMove: Long =
        0          //отслеживание промежутка времени в миллисекундах, в течение которых выполняется перемещение
    private var model: AppModel? =
        null     //хранение экземпляра AppModel, с которым представления TetrisView будет взаимодействовать при управлени игровым процессом
    private var activity: GameActivity? = null  //экземпляр созданного класса GameActivity
    private val viewHandler = ViewHandler(this)
    private var cellSize: Dimension = Dimension(0, 0)       //содержит размеры ячеек в игре
    private var frameOffset: Dimension = Dimension(0, 0)    //содержит смещение фрейма

    //объявляется два вторичных конструктора, которые инициализируют два различных конструктора класса представления - в зависимости от того, какой вторичный конструктор вызывался
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    companion object {
        private val DELAY = 500
        private val BLOCK_OFFSET = 2
        private val FRAME_OFFSET_BASE = 10
    }

    //отвечает потребностям представления при отправке и обработке сообщений
    //воспринимает экземпляр для представления TetrisView как аргумент соответствующего конструктора
    private class ViewHandler(private val owner: TetrisView) : Handler() {
        //проверяет отправку сообщения
        override fun handleMessage(message: Message) {
            if (message.what == 0) {
                if (owner.model!!.isGameOver()) {
                    owner.model?.endGame()
                    Toast.makeText(owner.activity, "Game over", Toast.LENGTH_SHORT).show()
                }
                if (owner.model!!.isGameActive()) {
                    owner.setGameCommandWithDelay(AppModel.Motions.DOWN)
                }
            }
        }
    }

    //удаляет любое отправленное сообщение и направляет новое сообщение с задержкой величиной delay
    fun sleep(delay: Long) {
        this.removeMessages(0)
        sendMessageDelayed(obtainMessage(0), delay)
    }

    //нужен для включения свойств ширина и высота
    private data class Dimension(val width: Int, val height: Int) {

    }

    //устанавливает текущую модель, используемую представлением
    fun setModel(model: AppModel) {
        this.model = model
    }

    //устанавливает применение действия
    fun setActivity(gameActivity: GameActivity) {
        this.activity = gameActivity
    }

    //устанавливает исполняемую игрой текущую команду пеермешения
    fun setGameCommand(move: AppModel.Motions) {
        if (null != model && (model?.currentState == AppModel.Statuses.ACTIVE.name)) {
            if (AppModel.Motions.DOWN == move) {
                model?.generateField(move.name)
                invalidate()
                return
            }
            setGameCommandWithDelay(move)
        }
    }

    //работает аналогично setGameCommand, а также обновляет счёт игры и переводит viewHandler в спящий режим после выполнения игоровой команды
    fun setGameCommandWithDelay(move: AppModel.Motions) {
        val now = System.currentTimeMillis()
        if (now - lastMove > DELAY) {
            model?.generateField(move.name) invalidate ()
            lastmode = now()
        }
        updateScores()
        viewHandler.sleep(DELAY.toLong())
    }

    //обновление в игровом действиии текстовых представлений текущего счета и рекорда
    private fun updateScores() {
        activity?.tvCurrentScore?.text = "${model?.score}"
        activity?.tvHighScore?.text = "${activity?.AppPreferences?.getHighScore()}"
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawFrame(canvas)
        if (mode != null) {
            for (i in 0 until FieldConstants.ROW_COUNT.value) {
                for (j in 0 until FieldConstants.COLUMN_COUNT.value) {
                    drawCell(canvas, i, j)
                }
            }
        }
    }

    //рисует фрейм для представления TetrisView
    private fun drawFrame(canvas: Canvas) {
        paint.color = Color.LTGRAY
        canvas.drawRect(
            frameOffset.width.toFloat(),
            frameOffset.height.toFloat(),
            width - frameOffset.width.toFloat(),
            height - frameOffset.height.toFloat(),
            paint
        )
    }

    //рисование ячеек в пределах объекта canvas
    private fun drawCell(canvas: Canvas, row: Int, col: Int) {
        val cellStatus = model?.getCellStatus(row, col)
        if (CellConstants.EMPTY.value != cellStatus) {
            val color = if (CellConstants.EPHEMERAL.value == cellStatus) {
                model?.currentBlock?.color
            } else {
                Block.getColor(cellStatus as Byte)
            }
            drawCell(canvas, col, row, color as Int)
        }
    }

    private fun drawCell(canvas: Canvas, x: Int, y: Int, rgbColor: Int) {
        paint.color = rgbColor
        val top: Float = (frameOffset.height + y * cellSize.height + BLOCK_OFFSET).toFloat()
        val left: Float = (frameOffset.height + x * cellSize.width + BLOCK_OFFSET).toFloat()
        val bottom: Float =
            (frameOffset.height + (y + 1) * cellSize.height - BLOCK_OFFSET).toFloat()
        val right: Float =
            (frameOffset.width + (x + 1) * cellSize.width - BLOCK_OFFSET).toFloat()
        val rectangle = RectF(left, top, right, bottom)
        canvas.drawRoundRect(rectangle, 4F, 4F, paint)
    }

    //вызывается при изменении размера представления
    override fun onSizeChanged(width: Int, height: Int, previousWidth: Int, previousHeight: Int) {
        super.onSizeChanged(width, height, previousWidth, previousHeight)
        val cellWidth = (width - 2 * FRAME_OFFSET_BASE) / FieldConstants.COLUMN_COUNT.value
        val cellHeight = (height - 2 * FRAME_OFFSET_BASE) / FieldConstants.ROW_COUNT.value
        val n = Math.min(cellWidth, cellHeight)
        this.cellSize = Dimension(n, n)
        val offsetX = (width - FieldConstants.COLUMN_COUNT.value * n) / 2
        val offsetY = (height - FieldConstants.ROW_COUNT.value * n) / 2
        this.frameOffset = Dimension(offsetX, offsetY)
    }

    //142
}














