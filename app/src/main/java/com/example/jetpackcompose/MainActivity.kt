package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.ui.theme.CustomComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CustomComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("hello world")
                }
            }
        }
    }
}

// Box

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(
    showBackground = true,
    name = "Testing My first app with JC",
    widthDp = 250,
    heightDp = 250
)
@Composable
fun GreetingPreview() {

    CustomComposeTheme {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green),
            // all children will be centered in the Box
            contentAlignment = Alignment.Center

        ) {
            Greeting("Carlos")

            Greeting(
                name = "Android",
                // custom alignment
                modifier = Modifier.align(Alignment.BottomEnd)
            )

        }
    }
}