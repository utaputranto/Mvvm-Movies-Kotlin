package com.triputranto.mvvmkotlin.entity

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("title") var title: String?
)