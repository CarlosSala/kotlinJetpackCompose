package com.example.jetpackcompose.ui.screenexamples.service2

import com.example.jetpackcompose.R
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*

class DownloadService : Service() {

    private val CHANNEL_ID = "DownloadServiceChannel"
    private var job: Job? = null
    private val TAG = "DownloadService"

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(1, createNotification(0))

        job = CoroutineScope(Dispatchers.IO).launch {
            for (progress in 1..100) {
                delay(100) // Simula progreso cada 100 ms
                updateNotification(progress)
                Log.d("DownloadService", "Progreso: $progress%")
            }
            stopForeground(true)
            stopSelf()
        }

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Download Service Channel",
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }

    private fun createNotification(progress: Int): Notification {
        return Notification.Builder(this, CHANNEL_ID)
            .setContentTitle("Descarga en progreso")
            .setContentText("Progreso: $progress%")
            .setSmallIcon(R.drawable.ic_statistics)
            .setProgress(100, progress, false)
            .build()
    }

    private fun updateNotification(progress: Int) {
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.notify(1, createNotification(progress))
    }
}
