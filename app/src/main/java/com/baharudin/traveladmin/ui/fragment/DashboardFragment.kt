package com.baharudin.traveladmin.ui.fragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.baharudin.traveladmin.R
import com.baharudin.traveladmin.databinding.FragmentDashboardBinding
import com.baharudin.traveladmin.ui.LoginActivity
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
        binding.ivLogout.setOnClickListener {
            logOut()
        }

    }
    private fun logOut() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setTitle("Alert Dialog")
            .setMessage("Apakah anda ingin Logout")
            .setPositiveButton("Oke"
            ) { dialog, which ->
                preference.clear()
                Toast.makeText(
                    requireContext(),
                    "Tombol oke di klik",
                    Toast.LENGTH_SHORT
                ).show()
                startActivity(Intent(requireContext(),LoginActivity::class.java))
                activity?.finish()
            }
            .setNegativeButton("Batal"
            ) { dialog, which ->
                Toast.makeText(
                    context,
                    "Batal diklik",
                    Toast.LENGTH_SHORT
                ).show()
            }
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }

}