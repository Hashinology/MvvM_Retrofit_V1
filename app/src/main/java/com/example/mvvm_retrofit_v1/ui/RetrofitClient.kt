package com.example.mvvm_retrofit_v1.ui

import com.example.mvvm_retrofit_v1.models.Movies
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitClient {
    @GET("movielist.json")
    fun getMoviiesList(): Call<Movies>

    companion object{
        var instance: RetrofitClient? = null
        fun setUpInstanceValue(): RetrofitClient{
            if (instance == null){
                var retrofit = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                instance = retrofit.create(RetrofitClient::class.java)
            }
            return instance!!
        }
    }
}