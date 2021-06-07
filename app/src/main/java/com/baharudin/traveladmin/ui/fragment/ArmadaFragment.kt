package com.baharudin.traveladmin.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.baharudin.traveladmin.R
import com.baharudin.traveladmin.databinding.FragmentArmadaBinding

class ArmadaFragment : Fragment(R.layout.fragment_armada) {

    private var _binding : FragmentArmadaBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentArmadaBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        

    }
}