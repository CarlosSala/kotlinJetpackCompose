package com.example.jetpackcompose.ui.screenexamples.widgetthree

import android.content.Context
import android.util.Log
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

// Worker for periodic updates
class QuoteUpdateWorker(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {

        Log.d(KEY_LOG, "Updating quote widget")

        // Get all instances of the widget
        val glanceIds =
            GlanceAppWidgetManager(applicationContext).getGlanceIds(QuoteWidget::class.java)

        // Update each widget
        glanceIds.forEach { glanceId ->
            QuoteWidget().update(applicationContext, glanceId)
        }

        return Result.success()
    }
}
