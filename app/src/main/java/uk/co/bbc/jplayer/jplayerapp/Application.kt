package uk.co.bbc.jplayer.jplayerapp

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import uk.co.bbc.jplayer.Episode

class Application : android.app.Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("Application", "Startup!")
    }

    fun getImage(id: String) : Bitmap? {
//        val bytes = nativeGetImage(id)
//        if(bytes.isNotEmpty()) {
//            return BitmapFactory.decodeByteArray(bytes, 0, bytes.size, BitmapFactory.Options())
//        }
        val stringFromJNI = NativeBridge.staticStringFromJNI()
        Log.d("Application", stringFromJNI)
        return null
    }

    fun getEpisodes() : List<Episode>? {
        return arrayListOf(
                Episode("id1", "Title 1"),
                Episode("id2", "Title 2")
        )
    }

}

fun jPlayerApp(context: Context): Application {
    return context.applicationContext as Application
}
