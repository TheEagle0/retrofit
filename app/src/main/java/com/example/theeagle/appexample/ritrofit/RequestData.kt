package com.example.theeagle.appexample.ritrofit

import android.arch.lifecycle.MutableLiveData
import com.example.theeagle.appexample.entity.OuterObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RequestData {

    fun getDataWithRetrofit(): MutableLiveData<OuterObject> {
        val data: MutableLiveData<OuterObject> = MutableLiveData()
        val getData: GetData = RetrofitClient.getInstance().create(GetData::class.java)
        val call = getData.retrieveData()
        call.enqueue(object : Callback<OuterObject> {
            override fun onResponse(call: Call<OuterObject>, response: Response<OuterObject>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<OuterObject>, t: Throwable) {}

        })
        return data
    }

}