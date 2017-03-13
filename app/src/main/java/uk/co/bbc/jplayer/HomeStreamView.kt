package uk.co.bbc.jplayer

import android.graphics.Bitmap

interface HomeStreamView {

    interface ImageReceiver {
        fun receiveImage(image : Bitmap)
    }

    interface ImageLoader {
        fun loadImage(receiver : ImageReceiver)
    }

    interface Item : ImageLoader {
        fun getLabelText() : String
    }

    fun updateItems(items : List<Item>)
}
