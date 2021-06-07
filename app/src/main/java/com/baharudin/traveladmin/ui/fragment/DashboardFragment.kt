package com.baharudin.traveladmin.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.baharudin.traveladmin.MainActivity
import com.baharudin.traveladmin.R
import com.baharudin.traveladmin.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private var _binding : FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentDashboardBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)



    }
}