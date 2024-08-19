package com.example.ktorapplication.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktorapplication.data.network.Resource
import com.example.ktorapplication.databinding.ActivityMainBinding
import com.example.ktorapplication.ui.adapter.MovieListAdapter
import com.example.ktorapplication.viewmodels.MainViewModel

import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var movieListAdapter: MovieListAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieListAdapter = MovieListAdapter()
        binding.recyclerViewMovies.adapter = movieListAdapter
        binding.recyclerViewMovies.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            viewModel.movies.collect { resource ->
                when (resource) {
                    is Resource.Failure -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(
                            this@MainActivity,
                            resource.exception.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    Resource.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }

                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        movieListAdapter.submitList(resource.result)
                        movieListAdapter.notifyDataSetChanged()
                    }

                    else -> {
                        movieListAdapter.notifyDataSetChanged()

                    }
                }
            }
        }
    }
}
