package com.example.jetpackcompose.ui.screenexamples.widgetone

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.Button
import androidx.glance.ButtonDefaults
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.wear.tiles.action.ActionCallback
import androidx.glance.wear.tiles.action.actionRunCallback


class MyAppWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {

        // In this method, load data needed to render the AppWidget.
        // Use `withContext` to switch to another thread for long running
        // operations.

        provideContent {
            // create AppWidget here
            MyWidget()
        }
    }

    @Composable
    private fun MyWidget() {

        GlanceTheme {
            Scaffold(
                titleBar = {}
            ) {

                val preferences = currentState<Preferences>()
                val currentQuote = preferences[stringPreferencesKey("quote")] ?: getQuote()

                Box(
                    modifier = GlanceModifier
                        .fillMaxSize()
                        .background(Color.LightGray)
                    /*      .clickable {

                      },*/,
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = GlanceModifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = GlanceModifier.padding(vertical = 10.dp),
                            text = currentQuote
                        )

                        Button(
                            text = "Change Quote",
                            onClick = actionRunCallback(UpdateQuoteAction::class.java),
                            modifier = GlanceModifier.padding(vertical = 10.dp),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = GlanceTheme.colors.onPrimary
                            )
                        )
                    }
                }
            }
        }
    }
}

fun getQuote(): String {

    val quote = listOf(
        "quote 1",
        "quote 2",
        "quote 3",
    )
    return quote.random()
}

class UpdateQuoteAction : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId
    ) {

        val newQuote = getQuote()

        updateAppWidgetState(context, glanceId) { prefs ->
            prefs[stringPreferencesKey("quote")] = newQuote
        }

        MyAppWidget().update(context, glanceId)
    }
}
