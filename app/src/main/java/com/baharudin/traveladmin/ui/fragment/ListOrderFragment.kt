package com.baharudin.traveladmin.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.baharudin.traveladmin.ui.DetailListOrderActivity
import com.baharudin.traveladmin.R
import com.baharudin.traveladmin.databinding.FragmentListOrderBinding
import com.google.firebase.database.*

class ListOrderFragment : Fragment(R.layout.fragment_list_order) {

    private var _binding : FragmentListOrderBinding ? = null
    private val binding get() = _binding!!
    private lateinit var databaseReference : DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentListOrderBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        databaseReference = FirebaseDatabase.getInstance().getReference("MyTicket")

        binding.ivBandung.setOnClickListener {
            val tiketBandung = Intent(requireContext(), DetailListOrderActivity::class.java)
            tiketBandung.putExtra("data_tiket","Bandung")
            startActivity(tiketBandung)
        }
        binding.ivBatang.setOnClickListener {
            val tiketBatang = Intent(requireContext(),DetailListOrderActivity::class.java)
            tiketBatang.putExtra("data_tiket","Batang")
            startActivity(tiketBatang)
        }
        binding.ivBekasi.setOnClickListener {
            val tiketBekasi = Intent(requireContext(), DetailListOrderActivity::class.java)
            tiketBekasi.putExtra("data_tiket","Bekasi")
            startActivity(tiketBekasi)
        }
        binding.ivCirebon.setOnClickListener {
            val tiketCirebon = Intent(requireContext(), DetailListOrderActivity::class.java)
            tiketCirebon.putExtra("data_tiket","Cirebon")
            startActivity(tiketCirebon)
        }
        binding.ivJakarta.setOnClickListener {
            val tiketJakarta = Intent(requireContext(), DetailListOrderActivity::class.java)
            tiketJakarta.putExtra("data_tiket","Jakarta")
            startActivity(tiketJakarta)
        }
        binding.ivJogja.setOnClickListener {
            val tiketJogja = Intent(requireContext(), DetailListOrderActivity::class.java)
            tiketJogja.putExtra("data_tiket","Jogja")
            startActivity(tiketJogja)
        }
        binding.ivMalang.setOnClickListener {
            val tiketMalang = Intent(requireContext(),DetailListOrderActivity::class.java)
            tiketMalang.putExtra("data_tiket","Malang")
            startActivity(tiketMalang)
        }
        binding.ivPekalongan.setOnClickListener {
            val tiketPekalongan = Intent(requireContext(), DetailListOrderActivity::class.java)
            tiketPekalongan.putExtra("data_tiket","Pekalongan")
            startActivity(tiketPekalongan)
        }
        binding.ivSemarang.setOnClickListener {
            val tiketSemarang = Intent(requireContext(), DetailListOrderActivity::class.java)
            tiketSemarang.putExtra("data_tiket","Semarang")
            startActivity(tiketSemarang)
        }
        binding.ivSukabumi.setOnClickListener {
            val tiketSukabumi = Intent(requireContext(), DetailListOrderActivity::class.java)
            tiketSukabumi.putExtra("data_tiket","Sukabumi")
            startActivity(tiketSukabumi)
        }
        binding.ivSurabaya.setOnClickListener {
            val tiketSurabaya = Intent(requireContext(), DetailListOrderActivity::class.java)
            tiketSurabaya.putExtra("data_tiket","Surabaya")
            startActivity(tiketSurabaya)
        }
        binding.ivTangerang.setOnClickListener {
            val tiketTangerang = Intent(requireContext(), DetailListOrderActivity::class.java)
            tiketTangerang.putExtra("data_tiket","Tangerang")
            startActivity(tiketTangerang)
        }

    }

}