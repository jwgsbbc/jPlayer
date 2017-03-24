package uk.co.bbc.jplayer

import android.graphics.Bitmap

class HomeStreamPresenter(private val imageService: ImageService, private val episodeService: EpisodeService) {

    private val imageCache: ImageCache = ImageCache()

    private var view: HomeStreamView? = null
    private var episodes: List<Episode> = emptyList()

    fun onStart(view: HomeStreamView) {
        this.view = view
        episodeService.getEpisodes {
            this.episodes = it
            this.view?.updateItems(episodes.map { toItem(it) })
        }
    }

    private fun toItem(episode: Episode): HomeStreamView.Item = object : HomeStreamView.Item {
        override val labelText: String get() {
            return episode.title
        }

        override val image: Bitmap? get() {
            val image: Bitmap? = imageCache.getImage(episode.id)
            if (image == null) {
                loadImage(episode.id)
            }
            return image
        }
    }

    fun onStop() {
        this.view = null
    }

    private fun loadImage(id: String) {
        imageService.getImage(id, {
            imageCache.setImage(id, it)
            view?.dataChangedForIndex(episodes.indexOfFirst { it.id == id })
        })
    }

}

