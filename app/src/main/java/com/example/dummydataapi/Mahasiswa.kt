package com.example.dummydataapi

data class Mahasiswa(

    val data: List<Data>

) {

    data class Data(

        val id: Int,
        val nim: String,
        val nama: String,
        val judul_ta: String,
        val kategori: Int,
        val pembimbing_1: String,
        val pembimbing_2: String,
        val penguji_1: String,
        val penguji_2: String,
        val status: String

    )

}