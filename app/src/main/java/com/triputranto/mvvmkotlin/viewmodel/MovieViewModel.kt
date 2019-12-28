package com.triputranto.mvvmkotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.triputranto.mvvmkotlin.BuildConfig.API_KEY
import com.triputranto.mvvmkotlin.entity.MovieResponse
import com.triputranto.mvvmkotlin.entity.Results
import com.triputranto.mvvmkotlin.utils.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MovieViewModel : ViewModel() {
    private val apiInterface = ApiUtils.getApi()
    private val listMutableLiveData = MutableLiveData<ArrayList<Results>>()

    fun getMovies(): LiveData<ArrayList<Results>> {
        return listMutableLiveData
    }

    fun setDiscoverMovie(language: String) {
        apiInterface.getMovies(API_KEY, language).enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        val movies: ArrayList<Results>? =
                            response.body()?.resultMovie?.let { ArrayList(it) }
                        listMutableLiveData.postValue(movies)
                    }
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }
        })
    }
}