package com.baharudin.traveladmin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baharudin.traveladmin.R
import com.baharudin.traveladmin.databinding.ActivitySopirActityBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SopirActity : AppCompatActivity() {

    private lateinit var binding : ActivitySopirActityBinding
    private lateinit var databaseReference : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySopirActityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseReference = FirebaseDatabase.getInstance().getReference("MyTicket")

        kotaTujuan()


    }
    private fun kotaTujuan() {
        binding.ivBandung.setOnClickListener {
            val tiketBandung = Intent(this, DetailListOrderActivity::class.java)
            tiketBandung.putExtra("data_tiket","Bandung")
            startActivity(tiketBandung)
        }
        binding.ivBatang.setOnClickListener {
            val tiketBatang = Intent(this,DetailListOrderActivity::class.java)
            tiketBatang.putExtra("data_tiket","Batang")
            startActivity(tiketBatang)
        }
        binding.ivBekasi.setOnClickListener {
            val tiketBekasi = Intent(this, DetailListOrderActivity::class.java)
            tiketBekasi.putExtra("data_tiket","Bekasi")
            startActivity(tiketBekasi)
        }
        binding.ivCirebon.setOnClickListener {
            val tiketCirebon = Intent(this, DetailListOrderActivity::class.java)
            tiketCirebon.putExtra("data_tiket","Cirebon")
            startActivity(tiketCirebon)
        }
        binding.ivJakarta.setOnClickListener {
            val tiketJakarta = Intent(this, DetailListOrderActivity::class.java)
            tiketJakarta.putExtra("data_tiket","Jakarta")
            startActivity(tiketJakarta)
        }
        binding.ivJogja.setOnClickListener {
            val tiketJogja = Intent(this, DetailListOrderActivity::class.java)
            tiketJogja.putExtra("data_tiket","Jogja")
            startActivity(tiketJogja)
        }
        binding.ivMalang.setOnClickListener {
            val tiketMalang = Intent(this,DetailListOrderActivity::class.java)
            tiketMalang.putExtra("data_tiket","Malang")
            startActivity(tiketMalang)
        }
        binding.ivPekalongan.setOnClickListener {
            val tiketPekalongan = Intent(this, DetailListOrderActivity::class.java)
            tiketPekalongan.putExtra("data_tiket","Pekalongan")
            startActivity(tiketPekalongan)
        }
        binding.ivSemarang.setOnClickListener {
            val tiketSemarang = Intent(this, DetailListOrderActivity::class.java)
            tiketSemarang.putExtra("data_tiket","Semarang")
            startActivity(tiketSemarang)
        }
        binding.ivSukabumi.setOnClickListener {
            val tiketSukabumi = Intent(this, DetailListOrderActivity::class.java)
            tiketSukabumi.putExtra("data_tiket","Sukabumi")
            startActivity(tiketSukabumi)
        }
        binding.ivSurabaya.setOnClickListener {
            val tiketSurabaya = Intent(this, DetailListOrderActivity::class.java)
            tiketSurabaya.putExtra("data_tiket","Surabaya")
            startActivity(tiketSurabaya)
        }
        binding.ivTangerang.setOnClickListener {
            val tiketTangerang = Intent(this, DetailListOrderActivity::class.java)
            tiketTangerang.putExtra("data_tiket","Tangerang")
            startActivity(tiketTangerang)
        }

    }
}