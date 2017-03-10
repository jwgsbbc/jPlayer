package uk.co.bbc.jplayer

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class HomeStreamViewImpl @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : RecyclerView(context, attrs, defStyleAttr) {

    init {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)

        adapter = object : Adapter<RecyclerView.ViewHolder>() {
            override fun getItemCount(): Int {
                return 10
            }

            override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
                val layoutInflater = LayoutInflater.from(context)
                val view = layoutInflater.inflate(R.layout.home_stream_cell, parent, false)
                return HomeStreamCellViewHolder(view)
            }

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
                val vh = holder as HomeStreamCellViewHolder
                vh.image.setImageResource(R.drawable.img_place_holder)
                vh.label.text = "Hello " + position
            }

            inner class HomeStreamCellViewHolder(view: View) : RecyclerView.ViewHolder(view) {
                val image: ImageView = itemView.findViewById(R.id.image) as ImageView
                val label: TextView = itemView.findViewById(R.id.label) as TextView
            }
        }
    }

}