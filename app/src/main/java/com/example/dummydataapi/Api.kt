package com.example.dummydataapi

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("ta")
    fun getMahasiswa(): Call<Mahasiswa>

}