package com.example.jetpackcompose.ui.screenexamples.firestorescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val userRepository: UserRepository

    init {
        val firestoreService = FireStoreService()
        userRepository = UserRepository(firestoreService)
    }

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun addUser(user: User) {
        viewModelScope.launch {
            userRepository.addUser(user).onFailure {
                _errorMessage.value = it.message
            }
        }
    }

    fun getUsers() {
        viewModelScope.launch {
            userRepository.getUsers().onSuccess {
                _users.value = it
            }.onFailure {
                _errorMessage.value = it.message
            }
        }
    }
}