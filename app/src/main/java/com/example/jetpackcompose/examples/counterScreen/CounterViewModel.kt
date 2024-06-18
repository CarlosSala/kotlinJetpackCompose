package com.example.jetpackcompose.examples.counterScreen

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

     var number = 0

    fun increment() {
        number++
    }
}