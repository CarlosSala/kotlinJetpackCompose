import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable

@Composable
fun WelcomeDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Bienvenido/a") },
        text = { Text(text = "¡Gracias por descargar nuestra app!") },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text(text = "Cerrar")
            }
        }
    )
}
