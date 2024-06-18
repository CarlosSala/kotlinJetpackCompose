package com.example.jetpackcompose.ui.screenExamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.CustomComposeTheme

class ColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

// Column

@Composable
fun Greeting2(name: String, textColor: Color = Color.Red, modifier: Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = textColor
    )
}

@Preview(
    showBackground = true,
    name = "Testing My first app with JC",
    widthDp = 200,
    heightDp = 300
)
@Composable
fun ColumnJC() {

    CustomComposeTheme {
        Column(
            // for to use all space in the screen
            modifier = Modifier
                .fillMaxSize()
                .border(2.dp, Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting2(
                "Android",
                modifier = Modifier
                    .background(Color.Yellow)
                    .weight(2f),
                textColor = Color.Blue
            )
            Greeting2(
                "Android",
                modifier = Modifier
                    .background(Color.Cyan)
                    .weight(1f)
            )
            Greeting2(
                "Android",
                modifier = Modifier
                    .background(Color.Blue)
                    .weight(1f)
            )
        }
    }
}