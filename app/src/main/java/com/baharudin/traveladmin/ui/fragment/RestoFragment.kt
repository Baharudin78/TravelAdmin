package com.baharudin.traveladmin.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.baharudin.traveladmin.R
import com.baharudin.traveladmin.adapter.RestoAdapter
import com.baharudin.traveladmin.data.Resto
import com.baharudin.traveladmin.databinding.FragmentRestoBinding
import com.baharudin.traveladmin.ui.TambahRestoActivity
import com.google.firebase.database.*

class RestoFragment : Fragment(R.layout.fragment_resto) {

    private lateinit var dataRef : DatabaseReference
    private var dataList = ArrayList<Resto>()
    private var _binding : FragmentRestoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentRestoBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        dataRef = FirebaseDatabase.getInstance().getReference("RestArea")

        setupRecycleview()
        showProgressBar()
        getDataResto()

        binding.btTambah.setOnClickListener {
            startActivity(Intent(requireContext(), TambahRestoActivity::class.java))
        }

    }
    private fun setupRecycleview() {
        binding.apply {
            rvResto.layoutManager = LinearLayoutManager(requireContext())
        }
    }
    private fun getDataResto() {
        dataRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (getResto in snapshot.children) {
                    val resto = getResto.getValue(Resto::class.java)
                    dataList.add(resto!!)
                }
                hideProgressBar()
                binding.rvResto.adapter = RestoAdapter(dataList)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireActivity(), error.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
    private fun showProgressBar() {
        binding.progressBar4.visibility = View.VISIBLE
    }
    private fun hideProgressBar() {
        binding.progressBar4.visibility = View.INVISIBLE
    }
}