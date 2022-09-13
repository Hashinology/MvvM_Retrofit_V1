package com.example.mvvm_retrofit_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_retrofit_v1.adapter.data.MovieAdapter
import com.example.mvvm_retrofit_v1.databinding.ActivityMainBinding
import com.example.mvvm_retrofit_v1.models.Movies
import com.example.mvvm_retrofit_v1.ui.MovieViews

class MainActivity : AppCompatActivity() {
    private lateinit var moveiView: MovieViews
    private lateinit var binding: ActivityMainBinding
    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this

        moveiView = ViewModelProvider(this).get(MovieViews::class.java)

        moveiView.getMovies.observe(this, Observer {
            setUpRecyclerView(it)
        })
    }

    private fun setUpRecyclerView(filmsList: Movies?) {
        movieAdapter = MovieAdapter(filmsList!!, this)
        binding.rvMovies.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }
}