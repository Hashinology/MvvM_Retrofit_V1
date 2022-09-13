package com.example.mvvm_retrofit_v1.adapter.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm_retrofit_v1.R
import com.example.mvvm_retrofit_v1.models.Movies

class MovieAdapter(
    val moviesList: Movies,
    val context: Context
): RecyclerView.Adapter<MovieAdapter.ViewsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewsHolder {
        val views = LayoutInflater.from(context).inflate(R.layout.movie_list_item, parent, false)
        return ViewsHolder(views)
    }

    override fun onBindViewHolder(holder: ViewsHolder, position: Int) {
        val data = moviesList.get(position)
        Glide.with(holder.movieImage.context)
            .load(data.imageUrl)
            .into(holder.movieImage)
        holder.movieName.text = data.name
        holder.movieCategory.text = data.category
        holder.movieDesc.text = data.desc
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    class ViewsHolder(viewItem: View): RecyclerView.ViewHolder(viewItem) {
        val movieImage = itemView.findViewById<ImageView>(R.id.ivMovie)
        val movieName = itemView.findViewById<TextView>(R.id.tvMovieName)
        val movieCategory = itemView.findViewById<TextView>(R.id.tvMovieCategory)
        val movieDesc = itemView.findViewById<TextView>(R.id.tvMovieDesc)
    }
}