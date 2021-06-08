package com.baharudin.traveladmin.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.baharudin.traveladmin.R
import com.baharudin.traveladmin.data.Travel
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

        }
        binding.ivBandung.setOnClickListener {

        }
        binding.ivBatang.setOnClickListener {

        }
        binding.ivBekasi.setOnClickListener {

        }
        binding.ivCirebon.setOnClickListener {

        }
        binding.ivJogja.setOnClickListener {

        }
        binding.ivMalang.setOnClickListener {

        }
        binding.ivPekalongan.setOnClickListener {

        }
        binding.ivSemarang.setOnClickListener {

        }
        binding.ivSukabumi.setOnClickListener {

        }
        binding.ivSurabaya.setOnClickListener {

        }
        binding.ivTangerang.setOnClickListener {

        }

    }
    private fun sendData(travels : Travel) {
    }
}