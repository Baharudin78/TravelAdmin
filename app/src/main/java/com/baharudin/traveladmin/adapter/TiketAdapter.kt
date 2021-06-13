package com.baharudin.traveladmin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.baharudin.traveladmin.data.Tiket
import com.baharudin.traveladmin.databinding.ItemOrderListBinding

class TiketAdapter(private var data : List<Tiket>) : RecyclerView.Adapter<TiketAdapter.TiketHolder>() {

    inner class TiketHolder(val binding : ItemOrderListBinding) :RecyclerView.ViewHolder(binding.root) {

        val tvNama : TextView = binding.tvNama
        val tvTujuanAwal : TextView = binding.tvTujuanawal
        val tvTujuanAkhir : TextView = binding.tvTujuanakhir
        val tvTanggal : TextView = binding.tvTanggal

        fun bindItem(data : Tiket) {
            tvNama.text = data.username
            tvTujuanAwal.text = data.tujuanAwal
            tvTujuanAkhir.text = data.tempatAwal
            tvTanggal.text = data.tanggal
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TiketHolder {
        val inflater = ItemOrderListBinding.inflate(
            LayoutInflater.from(
                parent.context
            ),
            parent,false
        )
        return TiketHolder(inflater)
    }

    override fun onBindViewHolder(holder: TiketHolder, position: Int) {
        holder.bindItem(data[position])
    }

    override fun getItemCount(): Int = data.size
}