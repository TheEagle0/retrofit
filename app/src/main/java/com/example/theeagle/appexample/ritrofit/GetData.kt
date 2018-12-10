package com.example.theeagle.appexample.ritrofit

import com.example.theeagle.appexample.entity.Result
import retrofit2.Call
import retrofit2.http.GET

interface GetData {

    @GET("search?api-key=17afcfca-d14d-4673-9df5-44e22e7d91df")
    fun retrieveData(): Call<Result>
}