package com.triputranto.mvvmkotlin.entity

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results") var resultMovie: List<Results>? = null
)