package com.example.jetpackcompose.ui.screenexamples.retrofit.data.repository

import com.example.jetpackcompose.ui.screenexamples.retrofit.data.repository.network.RemoteDataSource
import com.example.jetpackcompose.ui.screenexamples.retrofit.domain.model.Movie

class MovieRepository(private val remoteDataSource: RemoteDataSource) {

    // someone it is going to use this method and I am going to use this result

    suspend fun getMovies(region:String): List<Movie> {

        return remoteDataSource.getPopularMovies(region)
    }
}