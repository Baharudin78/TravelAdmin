package com.baharudin.traveladmin.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.baharudin.traveladmin.R
import com.baharudin.traveladmin.adapter.SopirAdapter
import com.baharudin.traveladmin.data.Sopir
import com.baharudin.traveladmin.databinding.FragmentSopirBinding
import com.baharudin.traveladmin.ui.TambahSopirActivity
import com.google.firebase.database.*

class SopirFragment : Fragment(R.layout.fragment_sopir) {

    private var _binding : FragmentSopirBinding? = null
    private val binding get() = _binding!!
    private lateinit var dataRef : DatabaseReference
    private var dataList = ArrayList<Sopir>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentSopirBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        dataRef = FirebaseDatabase.getInstance().getReference("Sopir")
        setupRecycleView()
        showProgressbar()
        getDataSopir()

        binding.btTambah.setOnClickListener {
            startActivity(Intent(requireContext(), TambahSopirActivity::class.java))
        }


    }
    private fun setupRecycleView() {
        binding.apply {
            rvSopir.layoutManager = LinearLayoutManager(requireContext())
        }
    }
    private fun getDataSopir() {
        dataRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (getSupir in snapshot.children) {
                    val sopir = getSupir.getValue(Sopir::class.java)
                    dataList.add(sopir!!)
                }
                hideProgresbar()
                binding.rvSopir.adapter = SopirAdapter(dataList)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), error.message , Toast.LENGTH_SHORT).show()
            }

        })
    }
    private fun showProgressbar() {
        binding.progressBar4.visibility = View.VISIBLE
    }
    private fun hideProgresbar() {
        binding.progressBar4.visibility = View.INVISIBLE
    }
}