package com.example.projectandroid

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.*
import android.widget.RatingBar.OnRatingBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_rating.*

class Rating : AppCompatActivity() {
    lateinit var ref : DatabaseReference

    var mRatingBar: RatingBar? = null
    var mRatingScale: TextView? = null
    var mFeedback: EditText? = null
    var mSendFeedback: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ref = FirebaseDatabase.getInstance().getReference("review")
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_rating)
        mRatingBar = findViewById<View>(R.id.ratingBar) as RatingBar
        mRatingScale = findViewById<View>(R.id.nilai) as TextView
        mFeedback = findViewById<View>(R.id.txtkomen) as EditText
        mSendFeedback = findViewById<View>(R.id.btn_simpan) as Button
        mRatingBar!!.onRatingBarChangeListener =
            OnRatingBarChangeListener { ratingBar, v, b ->
                mRatingScale!!.text = v.toString()
                when (ratingBar.rating.toInt()) {
                    1 -> mRatingScale!!.text = "Sangat Buruk"
                    2 -> mRatingScale!!.text = "Buruk"
                    3 -> mRatingScale!!.text = "Cukup Baik"
                    4 -> mRatingScale!!.text = "Baik"
                    5 -> mRatingScale!!.text = "Sangat Baik"
                    else -> mRatingScale!!.text = ""
                }
            }
        mSendFeedback!!.setOnClickListener {
            if (mFeedback!!.text.toString().isEmpty()) {
                Toast.makeText(
                    this@Rating,
                    "Harap Isi Kotak Teks Umpan Balik",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                mFeedback!!.setText("")
                mRatingBar!!.rating = 0f
                Toast.makeText(
                    this@Rating,
                    "Terima Kasih Telah Memberikan Tanggapan Anda",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btn_simpan.setOnClickListener {
            savedata()
        }
    }

    private fun savedata() {
        val nil = nilai.text.toString()
        val komen = txtkomen.text.toString()

        val revieww = Review(nil,komen)
        val reviewId = ref.push().key.toString()

        ref.child(reviewId).setValue(revieww).addOnCompleteListener {
            Toast.makeText(this, "Feedback Berhasil ditambahkan",Toast.LENGTH_SHORT).show()
            //ratingg.setText("")
            txtkomen.setText("")
        }
    }
}