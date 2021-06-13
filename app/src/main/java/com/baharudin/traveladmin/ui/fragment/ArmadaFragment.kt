package com.baharudin.traveladmin.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.baharudin.traveladmin.ui.ListArmadaActivity
import com.baharudin.traveladmin.R
import com.baharudin.traveladmin.databinding.FragmentArmadaBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ArmadaFragment : Fragment(R.layout.fragment_armada) {

    private var _binding : FragmentArmadaBinding? = null
    private val binding get() = _binding!!
    private lateinit var dataReference : DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentArmadaBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        dataReference = FirebaseDatabase.getInstance().getReference("Destination")

        binding.ivJakarta.setOnClickListener {
            val gotoJakarta = Intent(requireContext(), ListArmadaActivity::class.java)
            gotoJakarta.putExtra("lokasi_armada","Jakarta")
            startActivity(gotoJakarta)
        }
        binding.ivBandung.setOnClickListener {
            val gotoBandung = Intent(requireContext(), ListArmadaActivity::class.java)
            gotoBandung.putExtra("lokasi_armada","Bandung")
            startActivity(gotoBandung)
        }
        binding.ivBatang.setOnClickListener {
            val gotoBatang = Intent(requireContext(), ListArmadaActivity::class.java)
            gotoBatang.putExtra("lokasi_armada","Batang")
            startActivity(gotoBatang)
        }
        binding.ivBekasi.setOnClickListener {
            val gotoBekasi = Intent(requireContext(), ListArmadaActivity::class.java)
            gotoBekasi.putExtra("lokasi_armada","Bekasi")
            startActivity(gotoBekasi)
        }
        binding.ivCirebon.setOnClickListener {
            val gotoCirebon = Intent(requireContext(), ListArmadaActivity::class.java)
            gotoCirebon.putExtra("lokasi_armada","Cirebon")
            startActivity(gotoCirebon)
        }
        binding.ivJogja.setOnClickListener {
            val gotoJogja = Intent(requireContext(), ListArmadaActivity::class.java)
            gotoJogja.putExtra("lokasi_armada","Jogja")
            startActivity(gotoJogja)
        }
        binding.ivMalang.setOnClickListener {
            val gotoMalang = Intent(requireContext(), ListArmadaActivity::class.java)
            gotoMalang.putExtra("lokasi_armada","Malang")
            startActivity(gotoMalang)
        }
        binding.ivPekalongan.setOnClickListener {
            val gotoPekalongan = Intent(requireContext(), ListArmadaActivity::class.java)
            gotoPekalongan.putExtra("lokasi_armada","Pekalongan")
            startActivity(gotoPekalongan)
        }
        binding.ivSemarang.setOnClickListener {
            val gotoSemarang = Intent(requireContext(), ListArmadaActivity::class.java)
            gotoSemarang.putExtra("lokasi_armada","Semarang")
            startActivity(gotoSemarang)
        }
        binding.ivSukabumi.setOnClickListener {
            val gotoSukabumi = Intent(requireContext(), ListArmadaActivity::class.java)
            gotoSukabumi.putExtra("lokasi_armada","Sukabumi")
            startActivity(gotoSukabumi)
        }
        binding.ivSurabaya.setOnClickListener {
            val gotoSurabaya = Intent(requireContext(), ListArmadaActivity::class.java)
            gotoSurabaya.putExtra("lokasi_armada","Surabaya")
            startActivity(gotoSurabaya)
        }
        binding.ivTangerang.setOnClickListener {
            val gotoTangerang = Intent(requireContext(), ListArmadaActivity::class.java)
            gotoTangerang.putExtra("lokasi_armada","Tangerang")
            startActivity(gotoTangerang)
        }

    }
}