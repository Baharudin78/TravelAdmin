package com.baharudin.traveladmin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baharudin.traveladmin.data.Tiket
import com.baharudin.traveladmin.databinding.ActivityDetailTiketUserBinding

class DetailTiketUserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailTiketUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTiketUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Tiket>("tiket_user")

        binding.tvTujuanAwal.text = data?.tujuanAwal
        binding.tvDarimana.text = data?.tujuanAkhir
        binding.tvTujuanAkhir.text = data?.tempatAwal
        binding.tvKemana.text = data?.tempatAkhir
        binding.tvTanggal.text = data?.tanggal
        binding.tvTotal.text = data?.total

    }
}