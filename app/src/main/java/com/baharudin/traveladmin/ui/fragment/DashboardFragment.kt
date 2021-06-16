package com.baharudin.traveladmin.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.baharudin.traveladmin.R
import com.baharudin.traveladmin.databinding.FragmentDashboardBinding
import com.baharudin.traveladmin.util.Preference

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private var _binding : FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var preference : Preference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentDashboardBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        preference = Preference(requireContext())

        binding.tvNamaAdmin.text = preference.getData("username")


        binding.ivArmada.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_armadaFragment)
        }
        binding.ivOrderan.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_listOrderFragment)
        }
        binding.ivSopir.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_sopirFragment)
        }
        binding.ivResto.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_restoFragment)
        }

    }

}