package com.example.kings_demo.activities.notifications.notification_types

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.*

import androidx.appcompat.app.AppCompatActivity
import com.example.kings_demo.R

class Audio_notification : AppCompatActivity() {
    lateinit var context: Context
    lateinit var videoView: VideoView
    lateinit var playbtn: Button
    lateinit var pausebtn: Button
    var audio_url: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.audio_notification)
        context = this
        audio_url = intent.getStringExtra("audio_url").toString()
        playbtn = findViewById(R.id.play)
        pausebtn = findViewById(R.id.pause)

        // on below line we are
        // initializing our media player
        var mediaPlayer = MediaPlayer()

        playbtn.setOnClickListener {
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

            try {
                mediaPlayer.setDataSource(audio_url)
                Log.e("a_url",audio_url)
                mediaPlayer.prepare()
                mediaPlayer.start()
            } catch (e: Exception) {

                e.printStackTrace()
            }
            Toast.makeText(applicationContext, "Audio started playing..", Toast.LENGTH_SHORT).show()

        }

        pausebtn.setOnClickListener {
            if (mediaPlayer.isPlaying) {

                mediaPlayer.stop()
                mediaPlayer.reset()
                //mediaPlayer.release()

                Toast.makeText(applicationContext, "Audio has been  paused..", Toast.LENGTH_SHORT)
                    .show()

            } else {

                Toast.makeText(applicationContext, "Audio not played..", Toast.LENGTH_SHORT).show()
            }

        }
    }

}
      /*  videoView=findViewById(R.id.audio)
        audio_url=intent.getStringExtra("audio_url").toString()
        Log.e("tttt",audio_url)
        videoView.setVideoPath(audio_url);
        videoView.start()
        var ctlr =  MediaController(context);
        ctlr.setMediaPlayer(videoView)
        videoView.setMediaController(ctlr);
        videoView.requestFocus();
        val uri: Uri = Uri.parse(audio_url)*/

