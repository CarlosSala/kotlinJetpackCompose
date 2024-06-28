package com.example.jetpackcompose.ui.screenExamples.retrofit.main

import com.example.jetpackcompose.ui.screenExamples.retrofit.common.ServerMovieDataSource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcompose.ui.screenExamples.retrofit.data.repository.MovieRepository
import com.example.jetpackcompose.ui.screenExamples.retrofit.usecases.LoadPopularMoviesUseCase
import com.example.jetpackcompose.ui.screenExamples.retrofit.domain.model.*

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuoteViewModel() : ViewModel() {

    private val loadPopularMoviesUseCase = LoadPopularMoviesUseCase(
        MovieRepository(ServerMovieDataSource())
    )

    private val _progressVisible = MutableStateFlow(false)
    val progressVisible: StateFlow<Boolean> get() = _progressVisible

    private val _listPopularMovies = MutableStateFlow<List<Movie>>(emptyList())
    val listPopularMovies: StateFlow<List<Movie>> get() = _listPopularMovies

    private val _showMessage = MutableSharedFlow<String>()
    val showMessage: SharedFlow<String> get() = _showMessage


    fun requestPopularMovies(region: String) {

        viewModelScope.launch(Dispatchers.Main) {
            _progressVisible.value = true
            _listPopularMovies.value = loadPopularMoviesUseCase.loadPopularMovies(region)
            _progressVisible.value = false
        }
    }

    fun onMovieClicked(movie: Movie) {

        viewModelScope.launch {
            _showMessage.emit(movie.title)
        }
    }
}