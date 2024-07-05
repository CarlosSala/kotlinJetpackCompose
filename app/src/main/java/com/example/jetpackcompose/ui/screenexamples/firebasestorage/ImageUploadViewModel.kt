package com.example.jetpackcompose.ui.screenexamples.firebasestorage

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.launch

class ImageUploadViewModel : ViewModel() {
    private val storageReference: StorageReference = FirebaseStorage.getInstance().reference
    private val _uploadProgress = MutableStateFlow(0f)
    val uploadProgress: StateFlow<Float> = _uploadProgress

    fun uploadImage(uri: Uri, onSuccess: () -> Unit, onError: (Exception) -> Unit) {
        viewModelScope.launch {
            try {
                val fileReference = storageReference.child("images/${uri.lastPathSegment}")
                val uploadTask = fileReference.putFile(uri)
                uploadTask.addOnProgressListener { taskSnapshot ->
                    val progress = (100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount)
                    _uploadProgress.value = progress.toFloat()
                }.addOnSuccessListener {
                    onSuccess()
                }.addOnFailureListener { exception ->
                    onError(exception)
                }
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
}
