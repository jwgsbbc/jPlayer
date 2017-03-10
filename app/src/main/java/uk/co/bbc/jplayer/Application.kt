package uk.co.bbc.jplayer

import android.content.Context
import android.util.Log

class Application : android.app.Application() {

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("Application", "Startup!")
    }

    external fun stringFromJNI(): String
}

fun getApplication(context: Context): Application {
    return context.applicationContext as Application
}
