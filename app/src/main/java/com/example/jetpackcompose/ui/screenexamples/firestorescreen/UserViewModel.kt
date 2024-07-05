package com.example.jetpackcompose.ui.screenexamples.firestorescreen

import androidx.lifecycle.ViewModel
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

    private val _getUsersList = MutableStateFlow<List<User>>(emptyList())
    val getUserList: StateFlow<List<User>> = _getUsersList

    private val _getUserById = MutableStateFlow<Result<User?>>(Result.success(null))
    val getUserById: StateFlow<Result<User?>> = _getUserById

    private val _operationState = MutableStateFlow(Result.success(Unit))
    val operationState: StateFlow<Result<Unit>> = _operationState

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
                _getUsersList.value = it
            }.onFailure {
                _errorMessage.value = it.message
            }
        }
    }

    fun getUserById(userId: String) {
        viewModelScope.launch {
            _getUserById.value = userRepository.getUserById(userId)
        }
    }

    fun updateUser(userId: String, user: User) {
        viewModelScope.launch {
            _operationState.value = userRepository.updateUser(userId, user)
        }
    }

    fun deleteUser(userId: String) {
        viewModelScope.launch {
            _operationState.value = userRepository.deleteUser(userId)
        }
    }
}