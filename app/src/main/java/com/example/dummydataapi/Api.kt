package com.example.dummydataapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("ta")
    fun getMahasiswa(): Call<Mahasiswa>

    @GET("ta/nim/{nim}")
    fun getMahasiswabyNim(@Path("nim") nim: String): Call<Mahasiswa>

}