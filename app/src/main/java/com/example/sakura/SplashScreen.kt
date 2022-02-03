package com.example.sakura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timer = object :CountDownTimer(3000,1000){
            override fun onTick(millisUntiFinished: Long){}
            override fun onFinish() {
                val intent = Intent(this@SplashScreen,OnboardingScreen::class.java)
                startActivity(intent)
                finish()
            }
        }
        timer.start()

    }
}