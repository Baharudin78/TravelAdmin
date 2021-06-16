package com.baharudin.traveladmin.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.baharudin.traveladmin.data.Resto
import com.baharudin.traveladmin.databinding.ActivityTambahRestoBinding
import com.baharudin.traveladmin.util.Preference
import com.google.firebase.database.*

class TambahRestoActivity : AppCompatActivity() {

    private lateinit var iResto : String
    private lateinit var iLetak : String
    private lateinit var iTelepon : String

    private lateinit var dataRef : DatabaseReference
    private lateinit var firebaseInstance : FirebaseDatabase
    private lateinit var preference: Preference
    private lateinit var databaseRef : DatabaseReference

    private lateinit var binding : ActivityTambahRestoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahRestoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseInstance = FirebaseDatabase.getInstance()
        dataRef = FirebaseDatabase.getInstance().getReference("RestArea")
        databaseRef = firebaseInstance.getReference("RestArea")
        preference = Preference(this)

        binding.btDaftarNext.setOnClickListener {
            iResto = binding.etDaftarNama.text.toString()
            iLetak = binding.etLokasi.text.toString()
            iTelepon = binding.etTelepon.text.toString()

            if (iResto == ""){
                binding.etDaftarNama.error ="mohon isi nama resto"
                binding.etDaftarNama.requestFocus()
            }else if (iLetak == ""){
                binding.etLokasi.error ="isi lokasi resto"
                binding.etLokasi.requestFocus()
            }else if (iTelepon == ""){
                binding.etTelepon.error ="mohon isikan telepon resto"
                binding.etTelepon.requestFocus()
            }else{
                saveUser(iResto,iLetak,iTelepon)
            }
        }
    }
    private fun saveUser(iResto: String, iLetak: String, iTelepon: String) {
        val resto = Resto()

        resto.namaResto= iResto
        resto.letak = iLetak
        resto.telepon = iTelepon

        if (iResto != null){
            checkUser(iResto, resto)
        }
    }
    private fun checkUser(iResto: String, data : Resto) {
        databaseRef.child(iResto).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(Resto::class.java)

                if (user == null) {
                    databaseRef.child(iResto).setValue(data)
                    preference.setData("namaResto", data.namaResto)
                    preference.setData("letak", data.letak)
                    preference.setData("telepon", data.telepon)

                    val goRegister = Intent(this@TambahRestoActivity, MainActivity::class.java)
                    goRegister.putExtra("data",data)
                    startActivity(goRegister)
                } else {
                    Toast.makeText(this@TambahRestoActivity, "resto sudah ditambahkan", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@TambahRestoActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        })

    }
}