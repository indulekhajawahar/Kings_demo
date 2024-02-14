package com.example.kings_demo.activities.notifications.adapter

import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.kings_demo.R
import com.example.kings_demo.activities.notifications.notification_types.Audio_notification
import com.example.kings_demo.activities.notifications.notification_types.Image_notification
import com.example.kings_demo.activities.notifications.notification_types.Text_notification
import com.example.kings_demo.activities.notifications.notification_types.Video_notification

class Details_adapter (var mcontext: Context, var content_list:ArrayList<String>, var type_list:ArrayList<String>) :
    RecyclerView.Adapter<Details_adapter.ViewHolder>() {
    val text: String = "Text"
    val image: String = "Image"
    val video: String = "Video"
    val audio: String = "Audio"
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.notification_adapter, viewGroup, false)
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.type.setText(type_list[position]).toString()
        viewHolder.content?.setText(content_list[position])
        Log.e("cl", content_list.toString())
        Log.e("postn", content_list.toString())

        viewHolder.type?.setOnClickListener() {

            if (type_list[position]==text){
                Log.e("details", "text")
                val i = Intent(viewHolder.itemView.context, Text_notification::class.java)
                i.putExtra("text",content_list[0])
                viewHolder.itemView.context.startActivity(i)
            }
            else if (type_list[position]==image){
                Log.e("details", "image")
                val i = Intent(viewHolder.itemView.context, Image_notification::class.java)
                i.putExtra("image",content_list[1])
                viewHolder.itemView.context.startActivity(i)
            }
            else if (type_list[position]==video){
                Log.e("details", "video")
                val i = Intent(viewHolder.itemView.context, Video_notification::class.java)
                i.putExtra("video_url",content_list[position])
                viewHolder.itemView.context.startActivity(i)
            }
            else if (type_list[position]==audio){
                Log.e("details", "audio")
                val i = Intent(viewHolder.itemView.context, Audio_notification::class.java)
                i.putExtra("audio_url",content_list[position])
                viewHolder.itemView.context.startActivity(i)
            }
            else{
                Log.e("details", "details")
            }
        }
    }
    override fun getItemCount(): Int {
        return content_list.size

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var type: TextView
       var content: TextView? =null

        init {
            type = itemView.findViewById(R.id.notification_list)

        }
    }
}