package com.example.ktorapplication.data.repository

import com.example.ktorapplication.data.models.Movie
import com.example.ktorapplication.data.network.Resource


interface MoviesRepository {
    suspend fun getPopularMovies(): Resource<List<Movie>>
}

