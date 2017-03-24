package uk.co.bbc.jplayer

interface EpisodeService {
    fun getEpisodes(reciever : (List<Episode>) -> Unit )
}

