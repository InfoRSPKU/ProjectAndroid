package com.example.projectandroid

import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.RatingBar.OnRatingBarChangeListener
import androidx.appcompat.app.AppCompatActivity
class Rating : AppCompatActivity() {
    var mRatingBar: RatingBar? = null
    var mRatingScale: TextView? = null
    var mFeedback: EditText? = null
    var mSendFeedback: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)
        mRatingBar = findViewById<View>(R.id.ratingBar) as RatingBar
        mRatingScale = findViewById<View>(R.id.tvRatingScale) as TextView
        mFeedback = findViewById<View>(R.id.etFeedback) as EditText
        mSendFeedback = findViewById<View>(R.id.btnSubmit) as Button
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