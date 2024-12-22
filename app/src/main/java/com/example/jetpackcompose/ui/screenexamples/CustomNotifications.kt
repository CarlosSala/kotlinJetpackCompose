import android.Manifest
import android.app.Notification
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

@Composable
fun NotificationExample() {
    val context = LocalContext.current
    val channelId = "example_channel"
    val channelName = "Example Notifications"

    var hasNotificationPermission by remember { mutableStateOf(false) }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        hasNotificationPermission = isGranted
        if (!isGranted) {
            Toast.makeText(context, "Permiso de notificaciones denegado.", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(Unit) {
        hasNotificationPermission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            NotificationManagerCompat.from(context).areNotificationsEnabled()
        } else {
            true
        }
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val notificationChannel = NotificationChannel(
            channelId,
            channelName,
            NotificationManager.IMPORTANCE_HIGH
        )
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)
    }

    val simpleNotification = remember { createSimpleNotification(context, channelId) }
    val bigTextNotification = remember { createBigTextNotification(context, channelId) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (hasNotificationPermission) {
            Button(onClick = {
                if (checkNotificationPermission(context)) {
                    NotificationManagerCompat.from(context).notify(1, simpleNotification)
                } else {
                    Toast.makeText(
                        context,
                        "Permiso de notificaciones no otorgado.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }) {
                Text("Mostrar Notificación Simple")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                if (checkNotificationPermission(context)) {
                    NotificationManagerCompat.from(context).notify(2, bigTextNotification)
                } else {
                    Toast.makeText(
                        context,
                        "Permiso de notificaciones no otorgado.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }) {
                Text("Mostrar Notificación con Texto Largo")
            }
        } else {
            Button(onClick = {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                } else {
                    Toast.makeText(
                        context,
                        "Las notificaciones no requieren permiso en esta versión de Android.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }) {
                Text("Solicitar Permiso para Notificaciones")
            }
        }
    }
}

fun checkNotificationPermission(context: Context): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        NotificationManagerCompat.from(context).areNotificationsEnabled()
    } else {
        true // Permiso implícito en versiones anteriores
    }
}

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

@Preview
@Composable
fun PreviewNotificationExampleApp() {
    MaterialTheme {
        NotificationExample()
    }
}
