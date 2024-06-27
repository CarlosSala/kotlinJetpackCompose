package com.example.jetpackcompose.ui.screenExamples.viewpager

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MenuViewModel : ViewModel() {

    var currentPage by mutableIntStateOf(0)
        private set

    fun mySetCurrentPage(page: Int) {
        currentPage = page
    }
}
