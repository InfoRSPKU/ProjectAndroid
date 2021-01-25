package com.example.projectandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton

class Tentang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.halaman_tentang)

        val listt = findViewById<ImageButton>(R.id.btn_list)
        listt.setOnClickListener{
            val intent1 = Intent(this, ListRsActivity::class.java)
            startActivity(intent1)
        }

        val dettl = findViewById<ImageButton>(R.id.btn_about)
        dettl.setOnClickListener{
            val intent1 = Intent(this, Tentang::class.java)
            startActivity(intent1)
        }

    }
}