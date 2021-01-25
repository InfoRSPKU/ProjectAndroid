package com.example.projectandroid

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.list_rs.view.*

class RSRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<ListObjRS> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DosenViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_rs, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder){
            is DosenViewHolder -> {
                holder.bind(items.get(position))
                holder.klik.setOnClickListener {
                    holder.kalau_diklik(items.get(position))
                }
            }
        }
    }

    fun submitList(listDosen: List<ListObjRS>){
        items = listDosen
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class DosenViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val foto_rs: ImageView = itemView.gambar_rs
        val nama_rs: TextView = itemView.nama_rs
        val alm_rs : TextView = itemView.alamat_rs
        var klik : RelativeLayout = itemView.findViewById(R.id.rl_klik)

        fun bind(listObjDosen: ListObjRS){
            nama_rs.setText(listObjDosen.nama)
            alm_rs.setText(listObjDosen.alamat)

            val requestOp = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOp)
                .load(listObjDosen.gambar)
                .into(foto_rs)
        }

        fun kalau_diklik(get: ListObjRS){
            val position: Int = adapterPosition
            Toast.makeText(itemView.context,"Kamu memilih : ${get.nama}",
                Toast.LENGTH_SHORT)
                .show()

            val intent = Intent(itemView.context, DetailDosen::class.java)
            intent.putExtra("namanya", get.nama)
            intent.putExtra("alamatnya", get.alamat)
            intent.putExtra("fotonya", get.gambar)
            intent.putExtra("profilnya", get.profil)
            intent.putExtra("teleponnya", get.telepon)
            itemView.context.startActivity(intent)
        }
    }
}