package com.example.dummydataapi

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dummydataapi.databinding.ItemMahasiswaBinding

class MahasiswaAdapter(val listMahasiswa: List<Mahasiswa.Data>): RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemMahasiswaBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMahasiswaBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = listMahasiswa.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mahasiswa = listMahasiswa[position]
        holder.binding.tvName.text = mahasiswa.nama
        holder.binding.tvJudul.text = mahasiswa.judul_ta

        holder.itemView.setOnClickListener{

            val intent = Intent(holder.itemView.context, DetailMahasiswaActivity::class.java).apply{
                putExtra("intent_nama", mahasiswa.nama)
                putExtra("intent_nim", mahasiswa.nim)
                putExtra("intent_judul_ta", mahasiswa.judul_ta)
                putExtra("intent_kategori", mahasiswa.kategori)
                putExtra("intent_pembimbing_1", mahasiswa.pembimbing_1)
                putExtra("intent_pembimbing_2", mahasiswa.pembimbing_2)
                putExtra("intent_penguji_1", mahasiswa.penguji_1)
                putExtra("intent_penguji_2", mahasiswa.penguji_2)
                putExtra("intent_status", mahasiswa.status)
            }
            holder.itemView.context.startActivity(intent)
        }
    }
}