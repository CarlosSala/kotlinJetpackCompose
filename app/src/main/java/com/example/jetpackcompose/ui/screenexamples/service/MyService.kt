package com.example.jetpackcompose.ui.screenexamples.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MyService : Service() {

    private val tag = "my service"

    private var job: Job? = null

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        job = CoroutineScope(Dispatchers.IO).launch {
            while (isActive) {
                delay(1000)
                Log.d(tag, "my service")
            }
        }

        Log.d(tag, "start service")
        // todo
        return START_STICKY
    }

    override fun onDestroy() {

        Log.d(tag, "Destroy service")
        super.onDestroy()
        job?.cancel()
    }
}