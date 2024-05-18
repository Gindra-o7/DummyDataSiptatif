package com.example.dummydataapi

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dummydataapi.databinding.ActivityDetailMahasiswaBinding

class DetailMahasiswaActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailMahasiswaBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val mahasiswaNama = intent.getStringExtra("intent_nama")
        val mahasiswaNim = intent.getStringExtra("intent_nim")
        val mahasiswaJudulTa = intent.getStringExtra("intent_judul_ta")
        val mahasiswaKategori = intent.getIntExtra("intent_kategori",0)
        val mahasiswaPembimbing1 = intent.getStringExtra("intent_pembimbing_1")
        val mahasiswaPembimbing2 = intent.getStringExtra("intent_pembimbing_2")
        val mahasiswaPenguji1 = intent.getStringExtra("intent_penguji_1")
        val mahasiswaPenguji2 = intent.getStringExtra("intent_penguji_2")
        val mahasiswaStatus = intent.getStringExtra("intent_status")

        binding.tvNama.text = mahasiswaNama
        binding.tvNim.text = mahasiswaNim
        binding.tvJudulta.text = mahasiswaJudulTa
        binding.tvKategori.text = when (mahasiswaKategori) {
            1 -> "Laporan"
            2 -> "Paper Based"
            else -> "Tidak Diketahui"
        }
        binding.tvPembimbing1.text = mahasiswaPembimbing1
        binding.tvPembimbing2.text = mahasiswaPembimbing2
        binding.tvPenguji1.text = mahasiswaPenguji1
        binding.tvPenguji2.text = mahasiswaPenguji2
        binding.tvStatus.text = mahasiswaStatus

    }

    fun onBackPressed(view: View) {
        finish()
    }
}