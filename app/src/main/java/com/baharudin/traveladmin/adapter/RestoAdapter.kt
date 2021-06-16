package com.baharudin.traveladmin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.baharudin.traveladmin.R
import com.baharudin.traveladmin.data.Resto
import com.baharudin.traveladmin.databinding.ItemRestoBinding
import com.bumptech.glide.Glide

class RestoAdapter(private var data : List<Resto>) : RecyclerView.Adapter<RestoAdapter.RestoHolder>() {

    lateinit var contexAdaper : Context
    inner class RestoHolder(val binding : ItemRestoBinding) : RecyclerView.ViewHolder(binding.root) {
        private val tvNamaResto : TextView = binding.tvNamaResto
        private val tvNoTelepon : TextView = binding.tvHpResto
        private val tvAlamatResto : TextView = binding.tvAlamatResto
        private val  ivFotoResto : ImageView = binding.ivFotoResto

        fun bindItem(data: Resto, context: Context) {
            tvNamaResto.text = data.namaResto
            tvNoTelepon.text = data.telepon
            tvAlamatResto.text = data.letak
            Glide.with(context)
                .load(data.foto)
                .error(R.drawable.restoran)
                .into(ivFotoResto)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestoHolder {
        val inflater = ItemRestoBinding.inflate(
            LayoutInflater.from(
                parent.context
            ),
            parent,false
        )
        contexAdaper = parent.context
        return RestoHolder(inflater)
    }

    override fun onBindViewHolder(holder: RestoHolder, position: Int) {
        holder.bindItem(data[position],contexAdaper)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}