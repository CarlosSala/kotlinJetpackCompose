package com.example.jetpackcompose.ui.screenexamples.retrofit.common

import com.example.jetpackcompose.ui.screenexamples.retrofit.data.repository.network.MovieDbClient
import com.example.jetpackcompose.ui.screenexamples.retrofit.data.repository.network.RemoteDataSource
import com.example.jetpackcompose.ui.screenexamples.retrofit.domain.model.Movie

class ServerMovieDataSource : RemoteDataSource {

    // this result it will be used by other who will be using this
    override suspend fun getPopularMovies(region: String): List<Movie> {

        val popularMovies = MovieDbClient.service.getPopularMovies(
            "791a8c4d026076d931801fd25a0f9343",
            region
        )
        return popularMovies.results
    }
}