package uk.co.bbc.jplayer

import android.graphics.Bitmap

interface HomeStreamView {

    interface Item {
        val labelText: String
        val image: Bitmap?
    }

    fun updateItems(items : List<Item>)
    fun dataChangedForIndex(index: Int)
}
