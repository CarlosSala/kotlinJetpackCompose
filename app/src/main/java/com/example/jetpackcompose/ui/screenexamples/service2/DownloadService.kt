package com.example.jetpackcompose.ui.screenexamples.service2

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.jetpackcompose.R
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow

class DownloadService : Service(), CoroutineScope by CoroutineScope(Dispatchers.Main) {

    companion object {
        val progressFlow = MutableSharedFlow<Int>(replay = 1) // Shared flow for progress
    }

    private val CHANNEL_ID = "DownloadServiceChannel"

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(1, createNotification(0))

        // Simulates the download and emits progress
        launch(Dispatchers.IO) {
            try {
                for (progress in 1..100) {
                    delay(100) // Simulates progress every 100 ms
                    progressFlow.emit(progress) // Emit progress
                    updateNotification(progress)
                    Log.d("DownloadService", "Progress: $progress%")
                }
            } catch (e: Exception) {
                Log.e("DownloadService", "Error in download simulation", e)
            } finally {
                stopForeground(STOP_FOREGROUND_REMOVE)
                stopSelf()
            }
        }

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel() // Cancel the CoroutineScope
    }

    override fun onBind(intent: Intent?): IBinder? = null

    // this function is called to create the notification channel
    private fun createNotificationChannel() {
        val serviceChannel = NotificationChannel(
            CHANNEL_ID,
            "Download Service Channel",
            NotificationManager.IMPORTANCE_LOW
        )
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(serviceChannel)
    }

    // this function is called to create the notification
    private fun createNotification(progress: Int): Notification {
        return Notification.Builder(this, CHANNEL_ID)
            .setContentTitle("Download in progress")
            .setContentText("Progress: $progress%")
            .setSmallIcon(R.drawable.baseline_cloud_download_24)
            .setProgress(100, progress, false)
            .build()
    }

    // this function is called to update the progress displayed in the notification
    private fun updateNotification(progress: Int) {
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.notify(1, createNotification(progress))
    }
}