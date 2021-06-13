package com.baharudin.traveladmin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.baharudin.traveladmin.R
import com.baharudin.traveladmin.databinding.ActivityMainBinding

class   MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navigation = supportFragmentManager.findFragmentById(R.id.fragment2) as NavHostFragment
        navController = navigation.findNavController()


    }


}