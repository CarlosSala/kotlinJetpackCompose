package com.example.jetpackcompose.ui.screenExamples.retrofit.data.repository.network

import com.example.jetpackcompose.ui.screenExamples.retrofit.domain.model.Movie

interface RemoteDataSource {

    suspend fun getPopularMovies(region:String): List<Movie>
}