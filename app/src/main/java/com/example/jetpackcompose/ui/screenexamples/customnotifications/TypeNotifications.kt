package com.example.jetpackcompose.ui.screenexamples.customnotifications

import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

fun createSimpleNotification(context: Context, channelId: String): Notification {
    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_info)
        .setContentTitle("Notificación Simple")
        .setContentText("Esta es una notificación simple.")
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .build()
}

fun createBigTextNotification(context: Context, channelId: String): Notification {
    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_info)
        .setContentTitle("Notificación con Texto Largo")
        .setStyle(
            NotificationCompat.BigTextStyle().bigText(
                "Este es un ejemplo de notificación con más texto para mostrar BigTextStyle."
            )
        )
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .build()
}

fun createBigPictureNotification(context: Context, channelId: String): Notification {
    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_info)
        .setContentTitle("Notificación con Imagen Grande")
        .setStyle(
            NotificationCompat.BigPictureStyle()
                .bigPicture(
                    android.graphics.BitmapFactory.decodeResource(
                        context.resources,
                        android.R.drawable.ic_menu_gallery
                    )
                )
        )
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .build()
}

fun createReplyNotification(context: Context, channelId: String): Notification {
    val replyLabel = "Escribe tu respuesta aquí"
    val remoteInput = androidx.core.app.RemoteInput.Builder("key_text_reply")
        .setLabel(replyLabel)
        .build()

    val replyPendingIntent = PendingIntent.getBroadcast(
        context,
        0,
        Intent(context, NotificationReceiver2::class.java),
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
    )

    val action = NotificationCompat.Action.Builder(
        android.R.drawable.ic_menu_send,
        "Responder",
        replyPendingIntent
    ).addRemoteInput(remoteInput).build()

    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_email)
        .setContentTitle("Notificación con Respuesta Directa")
        .setContentText("Puedes responder directamente desde aquí.")
        .addAction(action)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .build()
}

fun createProgressNotification(context: Context, channelId: String): Notification {
    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_menu_save)
        .setContentTitle("Notificación de Progreso")
        .setContentText("Progreso en curso...")
        .setProgress(100, 50, false) // Progreso al 50%
        .setPriority(NotificationCompat.PRIORITY_LOW)
        .build()
}
fun createMessagingNotification(context: Context, channelId: String): Notification {
    val messagingStyle = NotificationCompat.MessagingStyle("Usuario Actual")
        .setConversationTitle("Conversación")
        .addMessage("Hola, ¿cómo estás?", System.currentTimeMillis(), "Amigo 1")
        .addMessage("¡Todo bien! ¿Y tú?", System.currentTimeMillis(), "Usuario Actual")
        .addMessage("¡Perfecto! 😊", System.currentTimeMillis(), "Amigo 2")

    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_email)
        .setStyle(messagingStyle)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .build()
}

fun createActionNotification(context: Context, channelId: String): Notification {
    // Intent para realizar una acción sin abrir una actividad
    val actionIntent = PendingIntent.getBroadcast(
        context,
        0, // Identificador único
        Intent(context, NotificationReceiver::class.java), // Un BroadcastReceiver en lugar de una actividad
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )

    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_input_add)
        .setContentTitle("Notificación con Acciones")
        .setContentText("Tiene opciones de acción.")
        .addAction(android.R.drawable.ic_menu_view, "Realizar acción", actionIntent)  // Acción personalizada
        .addAction(android.R.drawable.ic_menu_close_clear_cancel, "Cancelar", null)  // Acción de cancelar
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .build()
}

