package com.example.myapplication.helpers

class HelperFunctions {
    fun arrray2dOfByte(sizeOuter: Int, sizeInner: Int): Array<ByteArray> = Array(sizeOuter) {
        ByteArray(sizeInner)
    }
}