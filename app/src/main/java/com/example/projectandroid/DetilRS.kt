package com.example.projectandroid

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.detil_rs.*

class DetailDosen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.detil_rs)
        if (intent.hasExtra("namanya")){
            val nama: String = this.intent.getStringExtra("namanya").toString()
            val foto: String = this.intent.getStringExtra("fotonya").toString()
            val profil: String = this.intent.getStringExtra("profilnya").toString()
            val alamat: String = this.intent.getStringExtra("alamatnya").toString()
            val telepon: String = this.intent.getStringExtra("teleponnya").toString()
            setDetail(foto, nama, profil, alamat, telepon)


            val button1 = findViewById<Button>(R.id.btn_review)
            button1.setOnClickListener {
                val intent = Intent(this , Rating::class.java)
                startActivity(intent)
            }
        }
    }

    fun setDetail(foto: String, nama: String, profil: String, alamat: String, telepon: String){
        val requestOp = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        nama_detail_rs.text = nama
        profil_detail_rs.text = profil
        alamat_detail_rs.text = alamat
        telepon_detail_rs.text = telepon

        Glide.with(this)
            .load(foto)
            .apply(requestOp)
            .centerCrop()
            .into(foto_detail)
    }
}