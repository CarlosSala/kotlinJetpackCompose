package com.example.jetpackcompose.ui.screenexamples.firestorescreen

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FireStoreService {

    private val db = FirebaseFirestore.getInstance()
    private val usersCollection = db.collection("users")

    suspend fun addUser(user: User): Result<Unit> {
        return try {
            // Obtener una referencia de documento con ID autogenerado
            val documentRef = usersCollection.document()
            val userId = documentRef.id
            // Crear un usuario con el ID autogenerado
            val userWithId = user.copy(id = userId)
            // Guardar el usuario en Firestore con el ID autogenerado
            documentRef.set(userWithId).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getUsers(): Result<List<User>> {
        return try {
            val snapshot = usersCollection.get().await()
            snapshot.query.get().addOnSuccessListener {

            }
            val users = snapshot.toObjects(User::class.java)
            Result.success(users)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getUserById(userId: String): Result<User?> {
        return try {
            val document = usersCollection.document(userId).get().await()
            val user = document.toObject(User::class.java)
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun deleteUser(userId: String): Result<Unit> {
        return try {
            usersCollection.document(userId).delete().await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}