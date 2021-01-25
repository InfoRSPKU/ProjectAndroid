package com.example.projectandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton

class  Detil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.detail_rs_andini)

        fun About(view: View) {}
        val about = findViewById<ImageButton>(R.id.btn_about)
        about.setOnClickListener {
            val intent = Intent(this , Tentang::class.java)
            startActivity(intent)
        }

        fun List(view: View) {}
        val list = findViewById<ImageButton>(R.id.btn_list)
        list.setOnClickListener {
            val intent = Intent(this , Login::class.java)
            startActivity(intent)
        }

    }
}