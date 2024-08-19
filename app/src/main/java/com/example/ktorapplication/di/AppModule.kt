package com.example.ktorapplication.di

import com.example.ktorapplication.data.network.TMDBHttpClient
import com.example.ktorapplication.data.repository.MoviesRepository
import com.example.ktorapplication.data.repository.MoviesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient


@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun getHttpClient(httpClient: TMDBHttpClient): HttpClient = httpClient.getHttpClient()
    @Provides
    fun getMoviesRepository(impl: MoviesRepositoryImpl): MoviesRepository = impl
}

