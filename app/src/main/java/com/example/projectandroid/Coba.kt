package com.example.projectandroid

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.coba.*

class Coba : AppCompatActivity() {
    lateinit var ref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coba)

        ref = FirebaseDatabase.getInstance().getReference("USERS")
        btn_simpam.setOnClickListener {
            savedata()
        }
    }
    private fun savedata() {
        val namaa = nama.text.toString()
        val statuss = status.text.toString()

        val user = Coba1(namaa,statuss)
        val userId = ref.push().key.toString()

        ref.child(userId).setValue(user).addOnCompleteListener {
            Toast.makeText(this, "Successs", Toast.LENGTH_SHORT).show()
            nama.setText("")
            status.setText("")
        }
    }
}