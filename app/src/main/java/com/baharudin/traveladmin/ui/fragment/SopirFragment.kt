package com.baharudin.traveladmin.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.baharudin.traveladmin.R
import com.baharudin.traveladmin.databinding.FragmentSopirBinding

class SopirFragment : Fragment(R.layout.fragment_sopir) {

    private var _binding : FragmentSopirBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentSopirBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }
}