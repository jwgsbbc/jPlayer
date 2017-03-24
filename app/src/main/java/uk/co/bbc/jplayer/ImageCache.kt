package uk.co.bbc.jplayer

import android.graphics.Bitmap

class ImageCache {

    val cache : HashMap<String, Bitmap> = HashMap()

    fun getImage(id : String) : Bitmap? {
        return cache[id]
    }

    fun setImage(id: String, bitmap: Bitmap) {
        cache[id] = bitmap
    }

}