package com.example.jetpackcompose.ui.screenexamples.firestorescreen

class UserRepository(private val firestoreService: FireStoreService) {

    suspend fun addUser(user: User) = firestoreService.addUser(user)

    suspend fun getUsers() = firestoreService.getUsers()

    suspend fun getUserById(userId: String) = firestoreService.getUserById(userId)

    suspend fun deleteUser(userId: String) = firestoreService.deleteUser(userId)

    suspend fun updateUser(userId: String, user: User) = firestoreService.updateUser(userId, user)

}