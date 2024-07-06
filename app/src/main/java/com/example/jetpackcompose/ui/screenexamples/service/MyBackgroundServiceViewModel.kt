package com.example.jetpackcompose.ui.screenexamples.service

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel

class MyBackgroundServiceViewModel : ViewModel() {

    fun startMyBackgroundService(context: Context) {
        val intent = Intent(context, MyBackgroundService::class.java)
        context.startService(intent)
    }

    fun stopMyBackgroundService(context: Context) {
        val intent = Intent(context, MyBackgroundService::class.java)
        context.stopService(intent)
    }
}