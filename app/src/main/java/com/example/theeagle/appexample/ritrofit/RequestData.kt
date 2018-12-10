package com.example.theeagle.appexample.ritrofit

import android.arch.lifecycle.MutableLiveData
import com.example.theeagle.appexample.entity.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RequestData {
    val data: MutableLiveData<Result> = MutableLiveData()
    private val getData: GetData = RetrofitClient.getInstance().create(GetData::class.java)
    private val call = getData.retrieveData()
    fun getDataWithRetrofit(): MutableLiveData<Result> {

        call.enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {}

        })
        return data
    }

}