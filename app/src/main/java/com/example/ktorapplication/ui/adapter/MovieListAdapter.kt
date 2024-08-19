package com.example.ktorapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ktorapplication.R
import com.example.ktorapplication.data.models.Movie
import com.example.ktorapplication.databinding.MovieItemBinding

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    private val movies = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun submitList(movieList: List<Movie>) {
        movies.clear()
        movies.addAll(movieList)
    }

    class MovieViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.textViewTitle.text = movie.originalTitle
            binding.textViewOverview.text = movie.overview
            binding.textViewRating.text = "IMDB ${movie.voteAverage}"
            Glide.with(binding.imageViewPoster.context)
                .load(movie.fullPosterPath)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.bg_image_placeholder)
                        .error(R.drawable.bg_image_placeholder)
                        .fallback(R.drawable.bg_image_placeholder)
                )
                .into(binding.imageViewPoster)
        }
    }
}


