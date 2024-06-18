package com.example.jetpackcompose.ui.screenExamples.counterScreen

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

     var number = 0

    fun increment() {
        number++
    }
}