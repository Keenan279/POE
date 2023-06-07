package com.example.opscpoe

import android.graphics.Bitmap

object BitmapHolder {
    private val bitmapList: MutableList<Bitmap> = mutableListOf()

    fun addBitmap(bitmap: Bitmap) {
        bitmapList.add(bitmap)
    }

    fun getBitmap(index: Int): Bitmap? {
        return if (index >= 0 && index < bitmapList.size) {
            bitmapList[index]
        } else {
            null
        }
    }

    fun clearBitmaps() {
        bitmapList.clear()
    }
}