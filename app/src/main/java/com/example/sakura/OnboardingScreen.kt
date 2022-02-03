package com.example.sakura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class OnboardingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_screen)
    }

    fun goToSignIn(view: View) {
        val intent = Intent(this,SignInScreen::class.java)
        startActivity(intent)
    }
}