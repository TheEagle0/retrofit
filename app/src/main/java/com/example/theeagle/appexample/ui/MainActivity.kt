package com.example.theeagle.appexample.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.theeagle.appexample.R
import com.example.theeagle.appexample.adapter.Adapter
import com.example.theeagle.appexample.entity.DataEntity
import com.example.theeagle.appexample.entity.OuterObject


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel: ViewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        observeViewModel(viewModel)

    }

    private fun observeViewModel(viewModel: ViewModel) {
        viewModel.getDataObservable().observe(this, Observer { outerObject :OuterObject?->
            outerObject!!.bigObject.articleList.run {
                generateList(this)
            }
        })
    }

    private fun generateList(dataList: List<DataEntity>) {
        val recyclerView: RecyclerView = findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(dataList)
    }
}
