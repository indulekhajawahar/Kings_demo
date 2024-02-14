package com.example.kings_demo.activities.notifications.notification_types

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.kings_demo.R
import org.json.JSONException
import java.net.HttpCookie.parse

class Video_notification : AppCompatActivity() {
    lateinit var context: Context
    lateinit var videoView: VideoView
     var mediaControls: MediaController?=null
    var video_url: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video_notification)
        context = this
        videoView = findViewById(R.id.video)
        video_url = intent.getStringExtra("video_url").toString()
        Log.e("tttt", video_url)

        video()
    }
    private fun video(){
        videoView.setVideoPath(video_url);
        videoView.start()
        mediaControls =  MediaController(context);
        mediaControls!!.setVisibility(View.GONE)
        mediaControls!!.setAnchorView(videoView)
        mediaControls!!.setMediaPlayer(videoView)
        videoView.setMediaController(mediaControls);
        val uri: Uri = Uri.parse(video_url)
        videoView.setOnClickListener(){
            mediaControls!!.setVisibility(View.VISIBLE)
        }
    }
}