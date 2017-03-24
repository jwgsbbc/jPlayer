package uk.co.bbc.jplayer

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import uk.co.bbc.jplayer.jplayerapp.jPlayerApp
import kotlin.concurrent.thread

class MainActivity : Activity(), ImageService, EpisodeService {
    private val presenter = HomeStreamPresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val homeStreamView = findViewById(R.id.home_stream) as HomeStreamView
        presenter.onStart(homeStreamView)
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun getImage(id: String, receiver: (Bitmap) -> Unit) {
        thread(start = true) {
            val image = jPlayerApp(this).getImage(id)
            if(image!=null) { runOnUiThread { receiver.invoke(image) } }
        }
    }

    override fun getEpisodes(reciever: (List<Episode>) -> Unit) {
        thread(start = true) {
            val episodeList = jPlayerApp(this).getEpisodes()
            if(episodeList!=null) {
                runOnUiThread {
                    reciever.invoke(episodeList)
                }
            }
        }
    }

}


