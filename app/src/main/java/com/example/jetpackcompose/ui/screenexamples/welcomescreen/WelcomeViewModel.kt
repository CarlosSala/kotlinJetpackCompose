package com.example.jetpackcompose.ui.screenexamples.welcomescreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WelcomeViewModel(application: Application) : AndroidViewModel(application) {

    private val _welcomeShown = MutableStateFlow(false)
    val welcomeShown: StateFlow<Boolean> = _welcomeShown

    init {
        viewModelScope.launch {
            getWelcomeShown(application).collect {
                _welcomeShown.value = it
            }
        }
    }

    fun setWelcomeShown() {
        viewModelScope.launch {
            setWelcomeShown(getApplication())
            _welcomeShown.value = true
        }
    }

    fun clearDataStore() {
        viewModelScope.launch {
            clearDataStore(getApplication())
        }
    }

    fun removeWelcomeShownValue() {
        viewModelScope.launch {
            removeSpecificValue(getApplication())
        }
    }
}