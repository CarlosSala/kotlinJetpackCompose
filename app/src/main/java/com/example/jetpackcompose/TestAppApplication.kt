package com.example.jetpackcompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import scheduleQuoteUpdate

@HiltAndroidApp
class TestAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Schedule the widget update when the application is created
        scheduleQuoteUpdate(this)
    }
}
