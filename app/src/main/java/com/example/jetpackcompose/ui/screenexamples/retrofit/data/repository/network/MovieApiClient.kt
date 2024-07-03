package com.example.jetpackcompose.ui.screenexamples.retrofit.data.repository.network

import com.example.jetpackcompose.ui.screenexamples.retrofit.data.model.MovieDbResult
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiClient {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("region") page: String
    ): MovieDbResult
}