package com.example.jetpackcompose.ui.screenexamples.retrofit.usecases

import com.example.jetpackcompose.ui.screenexamples.retrofit.data.repository.MovieRepository
import com.example.jetpackcompose.ui.screenexamples.retrofit.domain.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoadPopularMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun loadPopularMovies(region: String): List<Movie> = withContext(Dispatchers.IO) {

        movieRepository.getMovies(region)
    }
}