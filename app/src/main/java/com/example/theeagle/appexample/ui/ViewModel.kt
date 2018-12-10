package com.example.theeagle.appexample.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.theeagle.appexample.entity.OuterObject
import com.example.theeagle.appexample.ritrofit.RequestData


class ViewModel(app: Application) : AndroidViewModel(app) {

    private var retrievedDataObservable = RequestData.getDataWithRetrofit()
    fun getDataObservable(): MutableLiveData<OuterObject> {
        return retrievedDataObservable
    }
}