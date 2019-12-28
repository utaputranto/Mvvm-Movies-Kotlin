package com.triputranto.mvvmkotlin.network

import com.triputranto.mvvmkotlin.entity.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("discover/movie/")
    fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<MovieResponse>
}