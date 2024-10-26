

import android.content.Context
import android.util.Log
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.work.*
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class QuoteWidget : GlanceAppWidget() {

    override suspend fun provideGlance(
        context: Context,
        id: GlanceId
    ) {
        // Get a random quote for display
        val quote = getRandomQuote()

        // Display the content of the widget
        provideContent {
            Column(modifier = GlanceModifier.fillMaxSize()) {
                Text(
                    text = quote,
                    style = TextStyle(fontSize = 16.sp),
                )
            }
        }
    }

    // Generate a random quote
    private fun getRandomQuote(): String {
        val quotes = listOf(
            "El éxito es la suma de pequeños esfuerzos.",
            "La vida es un 10% lo que me ocurre y un 90% cómo reacciono a ello.",
            "El fracaso es simplemente la oportunidad de comenzar de nuevo."
        )
        return quotes[Random.nextInt(quotes.size)]
    }
}


// Worker for periodic updates
class QuoteUpdateWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {

        Log.d("QuoteUpdateWorker", "Ejecutando actualización del widget")
        // Get all instances of the widget
        val glanceIds = GlanceAppWidgetManager(applicationContext).getGlanceIds(QuoteWidget::class.java)

        // Update each widget
        glanceIds.forEach { glanceId ->
            QuoteWidget().update(applicationContext, glanceId)
        }

        return Result.success()
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
