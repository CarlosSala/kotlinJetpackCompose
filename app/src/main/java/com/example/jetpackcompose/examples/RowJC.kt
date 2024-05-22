package com.example.jetpackcompose.examples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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

class RowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CustomComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting3("Android")
                }
            }
        }
    }
}

// Row

@Preview(
    showBackground = true,
    name = "Testing My first app with JC",
    widthDp = 200,
    heightDp = 200,
    // backgroundColor = 1111115
)
@Composable
fun GreetingPreview3() {

    CustomComposeTheme {
        // for to use all space in the screen
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Greeting3(
                "one",
                modifier = Modifier
                    .background(Color.Yellow)
                //.weight(2f)
            )
            Greeting3(
                "two",
                modifier = Modifier
                    .background(Color.Cyan)
                //.weight(1f)
            )
            Greeting3(
                "three",
                modifier = Modifier
                    .background(Color.Blue)
                //.weight(1f)
            )

        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}