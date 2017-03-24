package uk.co.bbc.jplayer

import android.graphics.Bitmap

interface ImageService {
    fun getImage(id : String, receiver: (Bitmap) -> Unit )
}