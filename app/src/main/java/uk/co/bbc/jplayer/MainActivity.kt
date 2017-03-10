package uk.co.bbc.jplayer

import android.app.Activity
import android.os.Bundle

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeStreamView = findViewById(R.id.home_stream) as HomeStreamView
        homeStreamView.updateItems(arrayListOf(
                object : HomeStreamView.Item {
                    override val label: String get() = "List Item 1"
                    override val imageLoader: HomeStreamView.ImageLoader get() {
                        return object : HomeStreamView.ImageLoader {
                            override fun loadImage(receiver: HomeStreamView.ImageReceiver) {

                            }
                        }
                    }
                },
                object : HomeStreamView.Item {
                    override val label: String get() = "List Item 2"
                    override val imageLoader: HomeStreamView.ImageLoader get() {
                        return object : HomeStreamView.ImageLoader {
                            override fun loadImage(receiver: HomeStreamView.ImageReceiver) {

                            }
                        }
                    }
                }
        ))
    }

}


