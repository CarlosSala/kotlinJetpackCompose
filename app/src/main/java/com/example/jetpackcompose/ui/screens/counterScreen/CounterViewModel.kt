package com.example.jetpackcompose.ui.screens.counterScreen

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

     var number = 0

    fun increment() {
        number++
    }
}