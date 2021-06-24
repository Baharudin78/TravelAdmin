package com.baharudin.traveladmin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.baharudin.traveladmin.data.Tiket
import com.baharudin.traveladmin.databinding.ActivityDetailTiketUserBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DetailTiketUserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailTiketUserBinding
    private lateinit var dataReference : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTiketUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Tiket>("tiket_user")
        dataReference = FirebaseDatabase.getInstance().getReference("Users")
            .child(data?.username!!)

        binding.tvTujuanAwal.text = data.tujuanAwal
        binding.tvDarimana.text = data.tujuanAkhir
        binding.tvTujuanAkhir.text = data.tempatAwal
        binding.tvKemana.text = data.tempatAkhir
        binding.tvTanggal.text = data.tanggal
        binding.tvTotal.text = data.total.toString()

        showProgressBar()
        getUserData()

        binding.btVerifikasi.setOnClickListener {
            binding.btVerifikasi.visibility = View.INVISIBLE
            showText()
        }
    }
    private fun getUserData() {
        dataReference.get().addOnSuccessListener {
            if(it.exists()) {
                val namaPelanggan = it.child("username").value
                val noHpPelanggan = it.child("nohp").value
                val emailPelanggan = it.child("email").value
                hideProgressBar()
                Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show()
                binding.tvNamaPelanggan.text = namaPelanggan.toString()
                binding.tvHpPelanggan.text = noHpPelanggan.toString()
                binding.tvEmailPelanggan.text = emailPelanggan.toString()
            }else{
                Toast.makeText(this, "pelanggan gagal diambil", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Gagal mengambil data", Toast.LENGTH_SHORT).show()
        }
    }
    private fun showText() {
        binding.textVerifikasi.visibility = View.VISIBLE
    }
    private fun showProgressBar() {
        binding.progressBar5.visibility = View.VISIBLE
    }
    private fun hideProgressBar() {
        binding.progressBar5.visibility = View.INVISIBLE
    }

}