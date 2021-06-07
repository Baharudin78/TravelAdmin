package com.baharudin.traveladmin.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.baharudin.traveladmin.R
import com.baharudin.traveladmin.databinding.FragmentListOrderBinding

class ListOrderFragment : Fragment(R.layout.fragment_list_order) {

    private var _binding : FragmentListOrderBinding ? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentListOrderBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)


    }

}