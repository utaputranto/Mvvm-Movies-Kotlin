package com.triputranto.mvvmkotlin.utils

import com.triputranto.mvvmkotlin.network.ApiClient
import com.triputranto.mvvmkotlin.network.ApiInterface

object ApiUtils {

    fun getApi(): ApiInterface {
        return ApiClient.getClient().create(ApiInterface::class.java)
    }
}