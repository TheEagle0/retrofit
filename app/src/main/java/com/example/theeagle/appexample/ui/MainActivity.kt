package com.example.theeagle.appexample.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.theeagle.appexample.R
import com.example.theeagle.appexample.adapter.Adapter
import com.example.theeagle.appexample.entity.DataEntity
import com.example.theeagle.appexample.entity.OuterObject
import com.example.theeagle.appexample.ritrofit.GetData
import com.example.theeagle.appexample.ritrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val getData: GetData = RetrofitClient.getInstance().create(GetData::class.java)
        val call = getData.retrieveData()
        call.enqueue(object : Callback<OuterObject> {
            override fun onResponse(call: Call<OuterObject>, response: Response<OuterObject>) {
                response.body()
                generateList(response.body()!!.bigObject[0].articleList)

            }

            override fun onFailure(call: Call<OuterObject>, t: Throwable) {}

        })

    }

    fun generateList(dataList: MutableList<DataEntity>) {
        val recyclerView: RecyclerView = findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(dataList)
    }
}
