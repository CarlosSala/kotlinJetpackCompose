package com.example.jetpackcompose.ui.screenexamples.firebasestorage

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.launch

class ImageUploadViewModel : ViewModel() {

    private val storageReference = FirebaseStorage.getInstance().reference

    fun uploadImage(uri: Uri, onSuccess: () -> Unit, onError: (Exception) -> Unit) {
        viewModelScope.launch {
            try {
                val fileReference = storageReference.child("images/${uri.lastPathSegment}")
                fileReference.putFile(uri).await()
                onSuccess()
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
}
