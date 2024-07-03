package com.example.jetpackcompose.ui.screenexamples.tabrowscreen

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue

class TabRowViewModel : ViewModel() {

    var currentPage by mutableIntStateOf(0)
        private set

    fun mySetCurrentPage(page: Int) {
        currentPage = page
    }
}
