package com.example.jetpackcompose.ui.screenexamples.service

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel

class MyServiceViewModel : ViewModel() {

    fun startMyBackgroundService(context: Context) {
        val intent = Intent(context, MyService::class.java)
        context.startService(intent)
    }

    fun stopMyBackgroundService(context: Context) {
        val intent = Intent(context, MyService::class.java)
        context.stopService(intent)
    }
}