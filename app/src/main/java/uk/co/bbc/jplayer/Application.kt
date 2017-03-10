package uk.co.bbc.jplayer

import android.util.Log

class Application : android.app.Application() {

    override fun onCreate() {
        super.onCreate()

        Log.d("Application", "Startup!")

    }

}