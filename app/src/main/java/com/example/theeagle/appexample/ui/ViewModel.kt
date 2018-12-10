package com.example.theeagle.appexample.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import arrow.core.Option
import com.example.theeagle.appexample.entity.Result
import com.example.theeagle.appexample.ritrofit.RequestData
import kotlinx.coroutines.*


class ViewModel(app: Application) : AndroidViewModel(app) {


    @ExperimentalCoroutinesApi
    fun getDataObservable(): MutableLiveData<Result> {
        val retrievedDataObservable = runBlocking { withContext(Dispatchers.Default) { RequestData.getDataWithRetrofit() } }

        return retrievedDataObservable
    }
}