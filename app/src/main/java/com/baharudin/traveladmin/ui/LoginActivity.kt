package com.baharudin.traveladmin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.baharudin.traveladmin.data.Admin
import com.baharudin.traveladmin.databinding.ActivityLoginBinding
import com.baharudin.traveladmin.util.Preference
import com.google.firebase.database.*

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    lateinit var preference: Preference
    private lateinit var databaseReference : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseReference = FirebaseDatabase.getInstance().getReference("Admin")
        preference = Preference(this)

        binding.btMasuk.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE

            val iUsername = binding.etEmail.text.toString()
            val iPassword = binding.etPassword.text.toString()

            if (iUsername.isEmpty() || iPassword.isEmpty()){
                binding.apply {
                    etEmail.error = "masukkan username yang benar"
                    etEmail.requestFocus()
                    etPassword.error = "masukkan password yang benar"
                    etPassword.requestFocus()
                }
                binding.progressBar.visibility = View.VISIBLE
            }else {
                loginFromFirebase(iUsername, iPassword)
                binding.progressBar.visibility = View.INVISIBLE
            }
        }
    }
    private fun loginFromFirebase(iUsername : String, iPassword : String) {
        databaseReference.child(iUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val admin = snapshot.getValue(Admin::class.java)
                if (admin == null) {
                    Toast.makeText(this@LoginActivity, "Username Belum terdaftar", Toast.LENGTH_SHORT)
                            .show()
                } else {
                    if (admin.password == iPassword) {
                        preference.setData("username", admin.username)
                        preference.setData("password", admin.password)
                        preference.setData("status", "1")
                        finishAffinity()
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    } else {
                        Toast.makeText(this@LoginActivity, "Password salah",
                                Toast.LENGTH_SHORT)
                                .show()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@LoginActivity
                        , error.message
                        , Toast.LENGTH_SHORT)
                        .show()
            }

        })
    }
}