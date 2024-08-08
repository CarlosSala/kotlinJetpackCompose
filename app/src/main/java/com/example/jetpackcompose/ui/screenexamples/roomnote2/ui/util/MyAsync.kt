package com.example.jetpackcompose.ui.screenexamples.roomnote2.ui.util

import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.model.Task

/**
 * A generic class that holds a loading signal or the result of an async operation.
 */
sealed class MyAsync<out T> {

    data object Loading : MyAsync<Nothing>()

    data class Error(val errorMessage: Int) : MyAsync<Nothing>()

    data class Success<out T>(val data: T) : MyAsync<T>()
}