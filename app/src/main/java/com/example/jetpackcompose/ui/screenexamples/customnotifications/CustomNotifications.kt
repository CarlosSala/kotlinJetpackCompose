import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationManagerCompat
import com.example.jetpackcompose.ui.screenexamples.customnotifications.createActionNotification
import com.example.jetpackcompose.ui.screenexamples.customnotifications.createBigPictureNotification
import com.example.jetpackcompose.ui.screenexamples.customnotifications.createBigTextNotification
import com.example.jetpackcompose.ui.screenexamples.customnotifications.createMessagingNotification
import com.example.jetpackcompose.ui.screenexamples.customnotifications.createProgressNotification
import com.example.jetpackcompose.ui.screenexamples.customnotifications.createReplyNotification
import com.example.jetpackcompose.ui.screenexamples.customnotifications.createSimpleNotification

@Composable
fun NotificationExample() {

    val context = LocalContext.current
    val channelId = "example_channel"
    val channelName = "Example Notifications"

    // Create notification channel
    val notificationChannel = NotificationChannel(
        channelId,
        channelName,
        NotificationManager.IMPORTANCE_HIGH
    )

    // Register the channel with the system
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(notificationChannel)

    var hasNotificationPermission by remember { mutableStateOf(false) }

    // Check if the user has notification permission
    LaunchedEffect(Unit) {
        hasNotificationPermission = checkNotificationPermission(context)
    }

    // Request notification permission
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        hasNotificationPermission = isGranted
        if (!isGranted) {
            Toast.makeText(context, "Notification permission denied.", Toast.LENGTH_SHORT).show()
        }
    }

    // use remember to avoid(evitar) recreating the notification each time the composable recomposes
    val simpleNotification = remember { createSimpleNotification(context, channelId) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (hasNotificationPermission) {
            Button(onClick = {
                NotificationManagerCompat.from(context).notify(1, simpleNotification)
            }) {
                Text("Show Simple Notification")
            }
            Button(onClick = {
                NotificationManagerCompat.from(context)
                    .notify(2, createBigTextNotification(context, channelId))
            }) {
                Text("Show Big Text Notification")
            }
            Button(onClick = {
                NotificationManagerCompat.from(context)
                    .notify(5, createProgressNotification(context, channelId))
            }) {
                Text("Show Progress Notification")
            }
            Button(onClick = {
                NotificationManagerCompat.from(context)
                    .notify(6, createMessagingNotification(context, channelId))
            }) {
                Text("Show Messaging Notification")
            }
            Button(onClick = {
                NotificationManagerCompat.from(context)
                    .notify(7, createActionNotification(context, channelId))
            }) {
                Text("Show Notification with Actions")
            }
            Button(onClick = {
                NotificationManagerCompat.from(context)
                    .notify(8, createBigPictureNotification(context, channelId))
            }) {
                Text("Show Big Picture Notification")
            }
            Button(onClick = {
                NotificationManagerCompat.from(context)
                    .notify(9, createReplyNotification(context, channelId))
            }) {
                Text("Show Reply Notification")
            }
        } else {
            Button(onClick = {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                } else {
                    Toast.makeText(
                        context,
                        "Notifications do not require permission on this Android version.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }) {
                Text("Request Notification Permission")
            }
        }
    }
}

fun checkNotificationPermission(context: Context): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        NotificationManagerCompat.from(context).areNotificationsEnabled()
    } else {
        true // Implicit permission on older versions
    }
}