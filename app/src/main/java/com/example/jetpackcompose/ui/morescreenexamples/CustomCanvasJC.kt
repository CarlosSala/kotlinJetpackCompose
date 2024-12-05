package com.example.jetpackcompose.ui.morescreenexamples

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun CircularProgressCanvasJC() {

    var progress by remember { mutableFloatStateOf(0.7f) } // Progreso inicial (70%)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressCanvas(progress = progress)

        Spacer(modifier = Modifier.height(16.dp))

        // Control del progreso
        Slider(
            value = progress,
            onValueChange = { progress = it }, // Cambia el progreso
            valueRange = 0f..1f // Rango de 0 a 1
        )
    }
}

@Composable
fun CircularProgressCanvas(
    progress: Float, // Progreso entre 0f (0%) y 1f (100%)
    modifier: Modifier = Modifier.size(200.dp),
    backgroundColor: Color = Color.LightGray,
    progressColor: Color = Color.Blue,
    strokeWidth: Float = 20f
) {
    // Canvas para dibujar el gráfico circular
    Canvas(modifier = modifier) {
        // Radio del círculo basado en el tamaño disponible
        val radius = size.minDimension / 2

        // Centro del Canvas
        val center = Offset(x = size.width / 2, y = size.height / 2)

        // Dibuja el fondo del círculo
        drawCircle(
            color = backgroundColor,
            radius = radius - strokeWidth / 2,
            style = Stroke(width = strokeWidth) // Usa estilo de trazo para borde
        )

        // Dibuja el progreso como un arco
        drawArc(
            color = progressColor,
            startAngle = -90f, // Empieza desde la parte superior
            sweepAngle = 360 * progress, // Calcula el ángulo según el progreso
            useCenter = false, // No conecta el arco al centro
            style = Stroke(width = strokeWidth),
            topLeft = Offset(center.x - radius, center.y - radius), // Esquina superior izquierda
            size = Size(radius * 2, radius * 2) // Tamaño del arco
        )
    }
}
