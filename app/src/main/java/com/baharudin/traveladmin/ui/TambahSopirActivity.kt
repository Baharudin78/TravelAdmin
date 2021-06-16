package com.baharudin.traveladmin.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.baharudin.traveladmin.data.Resto
import com.baharudin.traveladmin.data.Sopir
import com.baharudin.traveladmin.databinding.ActivityTambahSopirBinding
import com.baharudin.traveladmin.util.Preference
import com.google.firebase.database.*

class TambahSopirActivity : AppCompatActivity() {

    private lateinit var iNamaSopir : String
    private lateinit var iTelepon : String

    private lateinit var dataRef : DatabaseReference
    private lateinit var firebaseInstance : FirebaseDatabase
    private lateinit var preference: Preference
    private lateinit var databaseRef : DatabaseReference

    private lateinit var binding : ActivityTambahSopirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahSopirBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseInstance = FirebaseDatabase.getInstance()
        dataRef = FirebaseDatabase.getInstance().getReference("Sopir")
        databaseRef = firebaseInstance.getReference("Sopir")
        preference = Preference(this)

        binding.btDaftarNext.setOnClickListener {
            iNamaSopir = binding.etDaftarSopir.text.toString()
            iTelepon = binding.etHpsopir.text.toString()

            if (iNamaSopir == ""){
                binding.etDaftarSopir.error ="mohon isi nama resto"
                binding.etDaftarSopir.requestFocus()
            }else if (iTelepon == ""){
                binding.etHpsopir.error ="mohon isikan telepon resto"
                binding.etHpsopir.requestFocus()
            }else{
                saveUser(iNamaSopir,iTelepon)
            }
        }
    }
    private fun saveUser(iNamaSopir: String,iTelepon: String) {
        val sopir = Sopir()

        sopir.namaSopir = iNamaSopir
        sopir.nohp = iTelepon

        if (iNamaSopir != null){
            checkUser(iNamaSopir,sopir)
        }
    }
    private fun checkUser(iNamaSopir: String, data : Sopir) {
        databaseRef.child(iNamaSopir).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(Resto::class.java)

                if (user == null) {
                    databaseRef.child(iNamaSopir).setValue(data)
                    preference.setData("namaSopir", data.namaSopir)
                    preference.setData("nohp", data.nohp)

                    val goRegister = Intent(this@TambahSopirActivity, MainActivity::class.java)
                    goRegister.putExtra("data",data)
                    startActivity(goRegister)
                } else {
                    Toast.makeText(this@TambahSopirActivity, "sopir sudah ditambahkan", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@TambahSopirActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        })

    }
}