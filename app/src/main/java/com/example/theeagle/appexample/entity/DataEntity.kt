package com.example.theeagle.appexample.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class DataEntity(@field:SerializedName("sectionName") @Expose val articleName: String, @field:SerializedName("webTitle") @Expose val section: String)

data class DataList(@field:SerializedName("results") @Expose var articleList: MutableList<DataEntity>)

data class OuterObject(@field:SerializedName("response") @Expose val bigObject:DataList)