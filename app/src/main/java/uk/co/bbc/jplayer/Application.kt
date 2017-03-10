package uk.co.bbc.jplayer

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



}