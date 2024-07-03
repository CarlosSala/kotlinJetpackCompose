package com.example.jetpackcompose.ui.screenexamples.retrofit.data.repository.network

import com.example.jetpackcompose.ui.screenexamples.retrofit.domain.model.Movie

interface RemoteDataSource {

    suspend fun getPopularMovies(region:String): List<Movie>
}