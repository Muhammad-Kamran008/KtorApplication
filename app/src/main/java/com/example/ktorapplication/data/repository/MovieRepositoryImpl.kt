package com.example.ktorapplication.data.repository

import com.example.ktorapplication.data.models.Movie
import com.example.ktorapplication.data.models.PopularMovies
import com.example.ktorapplication.data.network.BASE_URL
import com.example.ktorapplication.data.network.Resource
import io.ktor.client.*
import io.ktor.client.request.*

import javax.inject.Inject
private const val POPULAR_MOVIES = "${BASE_URL}/popular"

class MoviesRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
) : MoviesRepository {
    override suspend fun getPopularMovies(): Resource<List<Movie>> {

        return try {
            Resource.Success(
                httpClient.get<PopularMovies> {
                    url(POPULAR_MOVIES)
                }.movies
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }

    }
}


