package com.example.jetpackcompose.ui.screenexamples.customnotifications

import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.Person


fun createSimpleNotification(context: Context, channelId: String): Notification {
    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_info)
        .setContentTitle("Simple Notification")
        .setContentText("This is a simple notification.")
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .build()
}

fun createBigTextNotification(context: Context, channelId: String): Notification {
    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_info)
        .setContentTitle("Notification with Long Text")
        .setStyle(
            NotificationCompat.BigTextStyle().bigText(
                "This is an example of a notification with more text to show BigTextStyle."
            )
        )
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .build()
}

fun createBigPictureNotification(context: Context, channelId: String): Notification {
    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_info)
        .setContentTitle("Notification with Big Image")
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
    val replyLabel = "Type your response here"
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
        "Reply",
        replyPendingIntent
    ).addRemoteInput(remoteInput).build()

    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_email)
        .setContentTitle("Notification with Direct Reply")
        .setContentText("You can reply directly from here.")
        .addAction(action)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .build()
}

fun createProgressNotification(context: Context, channelId: String): Notification {
    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_menu_save)
        .setContentTitle("Progress Notification")
        .setContentText("Progress in progress...")
        .setProgress(100, 50, false) // Progress at 50%
        .setPriority(NotificationCompat.PRIORITY_LOW)
        .build()
}

fun createMessagingNotification(context: Context, channelId: String): Notification {
    val friend1 = NotificationCompat.MessagingStyle.Message(
        "Hi, how are you?",
        System.currentTimeMillis(),
        Person.Builder()
            .setName("Friend 1")
            .build()
    )

    val currentUser = NotificationCompat.MessagingStyle.Message(
        "All good! And you?",
        System.currentTimeMillis(),
        Person.Builder()
            .setName("Current User")
            .setImportant(true) // Indica que es el usuario actual
            .build()
    )

    val friend2 = NotificationCompat.MessagingStyle.Message(
        "Perfect! 😊",
        System.currentTimeMillis(),
        Person.Builder()
            .setName("Friend 2")
            .build()
    )

    val messagingStyle = NotificationCompat.MessagingStyle(
        Person.Builder()
            .setName("Current User")
            .build()
    ).setConversationTitle("Conversation")
        .addMessage(friend1)
        .addMessage(currentUser)
        .addMessage(friend2)

    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_email)
        .setStyle(messagingStyle)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .build()
}


fun createActionNotification(context: Context, channelId: String): Notification {
    // Intent to perform an action without opening an activity
    val actionIntent = PendingIntent.getBroadcast(
        context,
        0, // Unique identifier
        Intent(
            context,
            NotificationReceiver::class.java
        ), // A BroadcastReceiver instead of an activity
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )

    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_input_add)
        .setContentTitle("Notification with Actions")
        .setContentText("It has action options.")
        .addAction(
            android.R.drawable.ic_menu_view,
            "Perform action",
            actionIntent
        )  // Custom action
        .addAction(android.R.drawable.ic_menu_close_clear_cancel, "Cancel", null)  // Cancel action
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .build()
}
