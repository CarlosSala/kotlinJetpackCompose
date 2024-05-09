package com.example.jetpackcompose

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.CustomComposeTheme

class MainActivity8 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomComposeTheme {
                /*     var text by rememberSaveable { mutableStateOf("") }
                     StateSample(
                         value = text,
                         onValueChange = { text = it }
                     )*/
                val (value, onValueChange) = rememberSaveable { mutableStateOf("") }
                StateSample(
                    value = value,
                    onValueChange = onValueChange
                )
            }
        }
    }
}


// @Preview(showBackground = true, widthDp = 400, heightDp = 400)
@Composable
fun StateSample(value: String, onValueChange: (String) -> Unit) {
    // val text = remember { mutableStateOf("") }
    // var text by remember { mutableStateOf("") }
    // var text by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.Center

    ) {

        TextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = value,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(8.dp)
        )
        Button(
            onClick = { onValueChange("") },
            modifier = Modifier.fillMaxWidth(),
            enabled = value.isNotEmpty()
        ) {
            Text(text = "Clear")
        }
    }

}