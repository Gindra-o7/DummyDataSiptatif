package com.example.dummydataapi

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dummydataapi.databinding.ActivityMahasiswaBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MahasiswaActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMahasiswaBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        RetrofitClient.instance.getMahasiswa().enqueue(object : Callback<Mahasiswa> {
            override fun onResponse(
                call: Call<Mahasiswa>,
                response: Response<Mahasiswa>
            ) {
                if (response.isSuccessful) {
                    val mahasiswaList = response.body()?.data
                    if (mahasiswaList != null && mahasiswaList.isNotEmpty()) {
                        showLoading(false)
                        setAdapter(mahasiswaList)
                    } else {
                        Toast.makeText(this@MahasiswaActivity, "No data found", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@MahasiswaActivity, "Failed to get data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Mahasiswa>, t: Throwable) {
                showLoading(false)
                Log.e("MahasiswaActivity", "Failed to get mahasiswa: ${t.message}")
                Toast.makeText(
                    this@MahasiswaActivity,
                    "Failed to get mahasiswa: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun setAdapter(data: List<Mahasiswa.Data>) {
        binding.rvMahasiwa.adapter = MahasiswaAdapter(data)
    }

    private fun showLoading(loading: Boolean){
        when(loading){
            true -> binding.progressBar.visibility = View.VISIBLE
            false -> binding.progressBar.visibility = View.GONE
        }
    }
}