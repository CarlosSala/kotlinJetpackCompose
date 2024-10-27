package com.example.jetpackcompose.ui.screenexamples.widgethree

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.color.ColorProvider
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.layout.wrapContentHeight
import androidx.glance.text.FontFamily
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import androidx.work.*
import java.util.concurrent.TimeUnit

class QuoteWidget : GlanceAppWidget() {

    override suspend fun provideGlance(
        context: Context,
        id: GlanceId
    ) {
        // Get a random quote for display
        val quote = getRandomQuote()

        // Display the content of the widget
        provideContent {
            QuoteWidgetScreen(quote)
        }
    }
}


@Composable
fun QuoteWidgetScreen(quote: String) {
    Box(
        modifier = GlanceModifier
            .fillMaxSize()
            .padding(12.dp)
            .background(Color.White)
            .cornerRadius(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = GlanceModifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = GlanceModifier,
                text = quote,
                style = TextStyle(
                    color = ColorProvider(
                        day = Color.DarkGray,
                        night = Color.White
                    ),
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
            )
        }
    }
}

// Schedule the worker
fun scheduleQuoteUpdate(context: Context) {
    val workRequest = PeriodicWorkRequestBuilder<QuoteUpdateWorker>(15, TimeUnit.MINUTES)
        .setConstraints(Constraints.NONE)
        .build()

    WorkManager.getInstance(context).enqueueUniquePeriodicWork(
        "QuoteUpdateWorker",
        ExistingPeriodicWorkPolicy.REPLACE,
        workRequest
    )
}
