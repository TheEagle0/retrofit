package com.example.theeagle.appexample.ritrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

        private lateinit var retrofit: Retrofit

        private const val url = "https://content.guardianapis.com/"

        fun getInstance(): Retrofit {
                retrofit = retrofit2.Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit
        }
    }
}