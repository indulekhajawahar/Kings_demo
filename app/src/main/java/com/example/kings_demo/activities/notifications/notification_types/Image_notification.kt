package com.example.kings_demo.activities.notifications.notification_types

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kings_demo.R

class Image_notification : AppCompatActivity() {
    lateinit var context: Context
    lateinit var image:ImageView
    var image_url:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_notification)
        context = this
       image=findViewById(R.id.image)
        image_url=intent.getStringExtra("image").toString()
        Log.e("im",image_url)
        if (image_url.isNotEmpty()) {
            context?.let {
                Glide.with(it)
                    .load(image_url)
                    .into(image)
            }!!
        }
        else
        {
           Log.e("fg","y")
        }
    }
}