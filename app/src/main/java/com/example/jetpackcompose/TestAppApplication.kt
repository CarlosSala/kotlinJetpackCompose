package com.example.jetpackcompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import com.example.jetpackcompose.ui.screenexamples.widgethree.scheduleQuoteUpdate

@HiltAndroidApp
class TestAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Schedule the widget update when the application is created
        scheduleQuoteUpdate(this)
    }
}
