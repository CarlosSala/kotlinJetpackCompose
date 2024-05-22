package com.example.jetpackcompose.examples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(
    showBackground = true,
    name = "Testing My first app with JC",
    widthDp = 200,
    heightDp = 200
)
@Composable
fun GreetingPreview2() {

    CustomComposeTheme {
        // for to use all space in the screen
        Column(
            modifier = Modifier.fillMaxSize(),
            // verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting2(
                "Android",
                modifier = Modifier
                    .background(Color.Yellow)
                    .weight(2f)
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