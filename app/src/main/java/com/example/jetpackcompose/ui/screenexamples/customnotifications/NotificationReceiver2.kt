package com.example.jetpackcompose.ui.screenexamples.customnotifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class NotificationReceiver2 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // Aquí puedes manejar la acción, por ejemplo:
        Log.d("NotificationReceiver", "Acción realizada desde la notificación")

        // Si necesitas hacer algo en segundo plano, puedes iniciar un servicio o ejecutar otro código aquí.
    }
}
