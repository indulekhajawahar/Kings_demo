package com.example.kings_demo

import android.content.Context
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.audio_notification.view.*


class Lines_Activity : AppCompatActivity() {
    lateinit var context: Context
lateinit var line1:ImageView
    lateinit var line2:ImageView
    lateinit var line3:ImageView
lateinit var line4:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lines)
        context = this
        line1=findViewById(R.id.line1)
        line2=findViewById(R.id.line2)
        line3=findViewById(R.id.line3)
line4=findViewById(R.id.line4)
        val rotate_1 = AnimationUtils.loadAnimation(
            this,
            R.anim.rotate_1)
        val rotate_2 = AnimationUtils.loadAnimation(
            this,
            R.anim.rotate_2)
        val rotate_3 = AnimationUtils.loadAnimation(
            this,
            R.anim.rotate_3)
        val line_shift=AnimationUtils.loadAnimation(
            this,
            R.anim.lineshift_right)

        line1.startAnimation(rotate_1)
        line2.startAnimation(rotate_2)
        //line3.startAnimation(rotate_3)
        line3.startAnimation(line_shift)


        line_shift.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationRepeat(animation: Animation) {

            }

            override fun onAnimationEnd(animation: Animation) {
                line3.startAnimation(rotate_3)

            }
        })

       /* val s = AnimationSet(true) //false means don't share interpolators

        s.addAnimation(line_shift)
        s.addAnimation(rotate_3)
        line3.startAnimation(s)*/

        /*val animation = TranslateAnimation(
            0.0f, 80.0f,
            0.0f, 0.0f
        )
        animation.setFillAfter(true)
        animation.isFillEnabled
        animation.duration = 5000
        animation.repeatCount = 1
        animation.repeatMode = 1
        line3.startAnimation(animation)*/
    }
}


