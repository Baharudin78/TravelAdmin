package com.baharudin.traveladmin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.baharudin.traveladmin.databinding.ActivitySplashBinding
import com.baharudin.traveladmin.ui.LoginActivity
import com.baharudin.traveladmin.ui.MainActivity
import com.baharudin.traveladmin.util.Preference


const val TIMING_SPLASH = 1000L
class SplashActivity : AppCompatActivity() {

    private lateinit var preference: Preference
    private lateinit var binding : ActivitySplashBinding
    private var usernameKey : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preference = Preference(this)
        getAdminPreference()
    }
    private fun getAdminPreference() {
        usernameKey = preference.getData("username")!!
        if (usernameKey.isEmpty()) {
            runnable
        }else {
            finishAffinity()
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
    private val runnable = Runnable {
        finishAffinity()
        startActivity(Intent(this, LoginActivity::class.java))
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