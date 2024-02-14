package com.example.kings_demo.activities.notifications.notification_types

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kings_demo.R

class Text_notification :AppCompatActivity() {
    lateinit var context: Context
    lateinit var textview:TextView
    var text:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_notification)
        context = this
        textview=findViewById(R.id.text)
        text=intent.getStringExtra("text").toString()
        Log.e("tttt",text)
        textview.setText(text)

    }
}