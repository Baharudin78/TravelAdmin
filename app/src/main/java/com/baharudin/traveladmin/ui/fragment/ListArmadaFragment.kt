package com.baharudin.traveladmin.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.baharudin.traveladmin.R
import com.baharudin.traveladmin.databinding.FragmentListArmadaBinding

class ListArmadaFragment : Fragment(R.layout.fragment_list_armada) {

    private var _binding : FragmentListArmadaBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentListArmadaBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

    }
}