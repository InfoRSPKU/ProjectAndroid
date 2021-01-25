package com.example.projectandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.tampilan_awal)

        fun LoginAdmin(view: View) {}
        val button1 = findViewById<Button>(R.id.btn_login)
        button1.setOnClickListener {
            val intent = Intent(this , Login::class.java)
            startActivity(intent)
        }

        fun Lanjutt(view: View) {}
        val button2= findViewById<Button>(R.id.btn_lanjut)
        button2.setOnClickListener {
            val intent = Intent(this , MapsActivity::class.java)
            startActivity(intent)
        }
    }
}