package com.baharudin.traveladmin.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.baharudin.traveladmin.adapter.TravelAdapter
import com.baharudin.traveladmin.data.Travel
import com.baharudin.traveladmin.databinding.ActivityListArmadaBinding
import com.google.firebase.database.*

class ListArmadaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListArmadaBinding
    private lateinit var mDatabaseRef : DatabaseReference
    var dataList = ArrayList<Travel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListArmadaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val lokasiBus = bundle!!.getString("lokasi_armada")

        binding.tvLokasi.text = lokasiBus

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Destination")
            .child(lokasiBus!!)
            .child("Travels")

        setupRecycleview()
        showProgresBar()
        getDataTravel()

    }
    private fun setupRecycleview() {
        binding.apply {
            rvDaftarTravel.layoutManager = LinearLayoutManager(this@ListArmadaActivity)

        }
    }
    private fun getDataTravel() {
        mDatabaseRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (getTravel in snapshot.children) {
                    val travel = getTravel.getValue(Travel::class.java)
                    dataList.add(travel!!)
                }
                hideProgressBar()
                binding.rvDaftarTravel.adapter = TravelAdapter(dataList)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ListArmadaActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
    private fun showProgresBar() {
        binding.progressBar2.visibility = View.VISIBLE
    }
    private fun hideProgressBar() {
        binding.progressBar2.visibility = View.INVISIBLE
    }
}