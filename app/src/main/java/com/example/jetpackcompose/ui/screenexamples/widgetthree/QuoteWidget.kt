package com.example.jetpackcompose.ui.screenexamples.widgetthree

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.ActionParameters
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.background
import androidx.glance.color.ColorProvider
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.wrapContentHeight
import androidx.glance.text.FontFamily
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import androidx.work.*
import java.util.concurrent.TimeUnit

private const val KEY_QUOTE_ES = "quoteEs"
private const val KEY_QUOTE_EN = "quoteEn"
const val KEY_LOG = "QuoteWidgetLog"

var myConfig = 0

class QuoteWidget : GlanceAppWidget() {

    override suspend fun provideGlance(
        context: Context,
        id: GlanceId
    ) {
        // Get a random quote for display
        val quote = getRandomQuote()

        // Display the content of the widget
        provideContent {
            QuoteWidgetScreen(quote = quote)
        }
    }
}

@Composable
fun QuoteWidgetScreen(quote: Phrase) {

    if (myConfig == 1) {
        val preferences = currentState<Preferences>()
        quote.apply {
            quoteEs = preferences[stringPreferencesKey(KEY_QUOTE_ES)] ?: getRandomQuote().quoteEs
            quoteEn = preferences[stringPreferencesKey(KEY_QUOTE_EN)] ?: getRandomQuote().quoteEn
        }
        myConfig = 0
    }

    Box(
        modifier = GlanceModifier
            .fillMaxSize()
            .cornerRadius(radius = 16.dp)
            .background(color = Color.White)
            .clickable(onClick = actionRunCallback(ChangeQuoteAction::class.java)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = GlanceModifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(all = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = GlanceModifier,
                text = quote.quoteEs,
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
            Spacer(modifier = GlanceModifier.height(8.dp))
            Text(
                modifier = GlanceModifier,
                text = quote.quoteEn,
                style = TextStyle(
                    color = ColorProvider(
                        day = Color.DarkGray,
                        night = Color.White
                    ),
                    fontSize = 12.sp,
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

class ChangeQuoteAction : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        Log.d(KEY_LOG, "onClick")

        myConfig = 1
        val newQuote = getRandomQuote()

        updateAppWidgetState(context, glanceId) { prefs ->
            prefs[stringPreferencesKey(KEY_QUOTE_ES)] = newQuote.quoteEs
            prefs[stringPreferencesKey(KEY_QUOTE_EN)] = newQuote.quoteEn
        }
        QuoteWidget().update(
            context = context,
            id = glanceId
        )
    }
}