package com.heyletscode.tetris.helpers

//генерирует и возвращает новый массив с указанными свойствами
//sizeOuter-номер строки создаваемого массива
//sizeInner-номер столбца сгенерированного массива байтов
fun array2dOfByte(sizeOuter: Int, sizeInner: Int): Array<ByteArray> = Array(sizeOuter) {
    ByteArray(sizeInner)
}
