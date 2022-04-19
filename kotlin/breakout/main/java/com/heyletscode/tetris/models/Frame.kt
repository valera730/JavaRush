package com.heyletscode.tetris.models

import com.heyletscode.tetris.helpers.array2dOfByte

class Frame(private val width: Int) {
    //width-ширина генерируемого фрейма (число столбцов в байтовом массиве фрейма)
    //data-список элементов массива в пространстве значений byteArray
    val data: ArrayList<ByteArray> = ArrayList()

    //обрабатывает строку, преобразуя каждый отдельный символ строки в байтовое представление и добавляет байтовое представление в байтовый массив, после чего байтовый массив добавляется в список данных
    fun addRow(byteStr: String): Frame {
        val row = ByteArray(byteStr.length)

        for (index in byteStr.indices) {
            row[index] = "$(byteStr[index])".toByte()
        }
        data.add(row)
        return this
    }

    //
    fun as2dByteArray(): Array<ByteArray> {
        val bytes = array2dOfByte(data.size, width)
        return data.toArray(bytes)
    }
}