package com.example.jetpackcompose.ui.screenexamples.retrofit.data.model

import com.example.jetpackcompose.ui.screenexamples.retrofit.domain.model.Movie


data class MovieDbResult (
    val page :Int,
    val results :List<Movie>,
    val total_pages :Int,
    val total_results :Int
)