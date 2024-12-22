package com.example.jetpackcompose.ui.screenexamples.customnotifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val replyText = androidx.core.app.RemoteInput.getResultsFromIntent(intent)
            ?.getCharSequence("key_text_reply") // Obtenemos la respuesta ingresada por el usuario.

        if (replyText != null) {
            // Procesar la respuesta. Ejemplo: mostrar un Toast.
            Toast.makeText(context, "Respuesta recibida: $replyText", Toast.LENGTH_LONG).show()
        }
    }
}
