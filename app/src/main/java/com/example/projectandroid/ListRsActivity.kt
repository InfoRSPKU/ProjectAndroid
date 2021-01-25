package com.example.projectandroid


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.list.*

class ListRsActivity : AppCompatActivity() {

    private lateinit var dosenAdapter: RSRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.list)
        initRecyclerView()
        tambahDataSet()
    }

    private fun tambahDataSet(){
        val data = SumberData.buatSetData()
        dosenAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@ListRsActivity)
            val spacingAtas = DekorasiSpasiGambar(20)
            addItemDecoration(spacingAtas)
            dosenAdapter = RSRecyclerAdapter()
            adapter = dosenAdapter
        }
    }
}