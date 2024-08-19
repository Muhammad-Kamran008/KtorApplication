package com.example.ktorapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorapplication.data.models.Movie
import com.example.ktorapplication.data.network.Resource
import com.example.ktorapplication.data.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MoviesRepository
) : ViewModel() {

    private val _movies = MutableStateFlow<Resource<List<Movie>>?>(null)
    val movies: StateFlow<Resource<List<Movie>>?> = _movies

    init {
        viewModelScope.launch {
            _movies.value = Resource.Loading
            _movies.value = repository.getPopularMovies()
        }
    }
}

