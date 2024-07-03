package com.example.jetpackcompose.ui.screenexamples.firestorescreen

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

data class User(
    val first: String = "",
    val last: String = "",
    val born: Int = 0
)

class FireStoreService {
    private val db = FirebaseFirestore.getInstance()
    private val usersCollection = db.collection("users")

    suspend fun addUser(user: User): Result<Unit> {
        return try {
            usersCollection.add(user).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getUsers(): Result<List<User>> {
        return try {
            val snapshot = usersCollection.get().await()
            val users = snapshot.toObjects(User::class.java)
            Result.success(users)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

class UserRepository(private val firestoreService: FireStoreService) {
    suspend fun addUser(user: User) = firestoreService.addUser(user)
    suspend fun getUsers() = firestoreService.getUsers()
}