package com.baharudin.traveladmin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.baharudin.traveladmin.adapter.TiketAdapter
import com.baharudin.traveladmin.data.Tiket
import com.baharudin.traveladmin.databinding.ActivityDetailListOrderBinding
import com.google.firebase.database.*

class DetailListOrderActivity : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference
    private lateinit var binding : ActivityDetailListOrderBinding
    private var dataList = ArrayList<Tiket>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailListOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val lokasiTiket = bundle!!.getString("data_tiket")

        binding.tvLokasiLiket.text = lokasiTiket
        databaseReference = FirebaseDatabase.getInstance().getReference("MyTicket")
            .child(lokasiTiket!!)

        showProgressBar()

        setupRecycleview()
        getListTiket()
        if (dataList.isEmpty()) {
            showIcon()
        }

    }

    private fun setupRecycleview() {
        binding.apply {
            rvDaftarTiketUser.layoutManager = LinearLayoutManager(this@DetailListOrderActivity)
        }
    }
    private fun getListTiket() {
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (getTiket in snapshot.children) {
                    val tiket = getTiket.getValue(Tiket::class.java)
                    dataList.add(tiket!!)
                }
                hideProgressBar()
                binding.rvDaftarTiketUser.adapter = TiketAdapter(dataList)

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DetailListOrderActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
    private fun showProgressBar() {
        binding.progressBar3.visibility = View.VISIBLE
    }
    private fun hideProgressBar() {
        binding.progressBar3.visibility = View.INVISIBLE
    }
    private fun showIcon() {
        binding.imageKosong.visibility = View.VISIBLE
        binding.textEmty.visibility = View.VISIBLE
    }
    private fun hideIcon() {
        binding.imageKosong.visibility = View.INVISIBLE
        binding.textEmty.visibility = View.INVISIBLE
    }
}