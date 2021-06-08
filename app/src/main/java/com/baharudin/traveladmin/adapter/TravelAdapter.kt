package com.baharudin.traveladmin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.baharudin.traveladmin.data.Travel
import com.baharudin.traveladmin.databinding.ItemListTravelBinding
import com.bumptech.glide.Glide

class TravelAdapter(private var data : List<Travel>) : RecyclerView.Adapter<TravelAdapter.TravelHolder>() {
    private lateinit var contextAdapter : Context
    inner class TravelHolder(val binding : ItemListTravelBinding) : RecyclerView.ViewHolder(binding.root) {
        private var ivFoto : ImageView = binding.ivFotoTravel
        private var tvNama : TextView = binding.tvNamaTravel
        private var tvFasilitas : TextView = binding.tvFasilitas
        private var tvHarga : TextView = binding.tvHarga

        fun bindData(data : Travel,context: Context) {
            tvNama.text = data.travel
            tvFasilitas.text = data.fasilitas
            tvHarga.text = data.harga
            Glide.with(context)
                .load(data.foto)
                .into(ivFoto)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelHolder {
        val inflater = ItemListTravelBinding.inflate(
            LayoutInflater.from(
                parent.context
            ),
            parent,false
        )
        contextAdapter = parent.context
        return TravelHolder(inflater)
    }

    override fun onBindViewHolder(holder: TravelHolder, position: Int) {
        holder.bindData(data[position],contextAdapter)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}