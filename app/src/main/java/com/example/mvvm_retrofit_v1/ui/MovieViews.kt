package com.example.mvvm_retrofit_v1.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_retrofit_v1.models.Movies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViews: ViewModel() {
    private val _getMovies: MutableLiveData<Movies> = MutableLiveData()
    var getMovies: LiveData<Movies> = _getMovies

    private val _errorMsg: MutableLiveData<String> = MutableLiveData()
    var errorMsg: LiveData<String> = _errorMsg

    init {
        getMoviesList()
    }

    private fun getMoviesList() {
        RetrofitClient.setUpInstanceValue().getMoviiesList().enqueue(object : Callback<Movies?> {
            override fun onResponse(call: Call<Movies?>, response: Response<Movies?>) {
                if (response.isSuccessful){
                    _getMovies.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Movies?>, t: Throwable) {
                _errorMsg.postValue(t.message)
            }
        })
    }
}