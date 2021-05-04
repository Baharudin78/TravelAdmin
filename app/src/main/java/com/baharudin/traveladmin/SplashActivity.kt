package com.baharudin.traveladmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper


const val TIMING_SPLASH = 1000L
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
    private val runnable = Runnable {
        finishAffinity()
        startActivity(Intent(this,LoginActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
        Handler(Looper.getMainLooper()).postDelayed(
            runnable, TIMING_SPLASH
        )
    }

    override fun onPause() {
        super.onPause()
        Handler(Looper.getMainLooper()).removeCallbacks(runnable)
    }

}