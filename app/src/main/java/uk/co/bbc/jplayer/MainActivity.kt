package uk.co.bbc.jplayer

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import uk.co.bbc.jplayer.jplayerapp.jPlayerApp

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById(R.id.sample_text) as TextView
        tv.text = jPlayerApp(this).stringFromJNI()
    }

}
