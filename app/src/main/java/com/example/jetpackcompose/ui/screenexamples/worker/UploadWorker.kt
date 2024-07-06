package com.example.jetpackcompose.ui.screenexamples.worker

import android.content.Context
import android.net.Uri
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.InputStream


class UploadWorker(
    context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val imageUri = inputData.getString("imageUri") ?: return Result.failure()
        val contentResolver = applicationContext.contentResolver
        val storageRef: StorageReference = FirebaseStorage.getInstance().reference

        return try {
            val inputStream: InputStream? = contentResolver.openInputStream(Uri.parse(imageUri))
            val imageRef: StorageReference = storageRef.child("images/${Uri.parse(imageUri).lastPathSegment}")

            inputStream?.let {
                val uploadTask = imageRef.putStream(it)
                val task = uploadTask.continueWithTask { task ->
                    if (!task.isSuccessful) {
                        task.exception?.let { throw it }
                    }
                    imageRef.downloadUrl
                }

                task.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Success logic, e.g., saving download URL
                    } else {
                        // Handle failure
                    }
                }
                Result.success()
            } ?: run {
                Result.failure()
            }
        } catch (e: Exception) {
            Result.failure()
        }
    }
}



/*
class UploadWorker(
    context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val imageUri = inputData.getString("imageUri") ?: return Result.failure()

        return try {
            val file = File(imageUri)
            val storageRef: StorageReference = FirebaseStorage.getInstance().reference
            val imageRef: StorageReference = storageRef.child("images/${file.name}")

            imageRef.putFile(file.toUri())
                .addOnSuccessListener {
                    Result.success()
                }
                .addOnFailureListener {
                    Result.failure()
                }

            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}
*/

/*class FileUploadWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        val fileUris = searchFiles()
        fileUris.forEach { uri ->
            uploadFileToFirebase(uri)
        }
        return Result.success()
    }

    private fun searchFiles(): List<Uri> {
        // Implementa la lógica para buscar archivos en el almacenamiento del dispositivo
        val uris = mutableListOf<Uri>()
        // Ejemplo básico: busca archivos en una carpeta específica
        val directory = File(Environment.getExternalStorageDirectory(), "YourFolder")
        if (directory.exists() && directory.isDirectory) {
            directory.listFiles()?.forEach { file ->
                uris.add(Uri.fromFile(file))
            }
        }
        return uris
    }

    private fun uploadFileToFirebase(fileUri: Uri) {
        val storage = Firebase.storage
        val storageRef = storage.reference
        val fileRef = storageRef.child("uploads/${UUID.randomUUID()}")

        val uploadTask = fileRef.putFile(fileUri)
        uploadTask.addOnSuccessListener {
            // Archivo subido con éxito
        }.addOnFailureListener {
            // Manejar error
        }
    }
}*/

