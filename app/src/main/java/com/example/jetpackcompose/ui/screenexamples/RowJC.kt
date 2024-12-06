package com.example.jetpackcompose.ui.screenexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    // the activity is ignored, this pass because the activity
                    // is not initialized with a startActivity
                    Greeting3(name = "Android")
                }
            }
        }
    }
}


@Preview(
    showBackground = true,
    name = "Testing My first app with JC",
    widthDp = 250,
    heightDp = 400,
    backgroundColor = 1111115
)
@Composable
fun RowJC() {

    CustomComposeTheme {
        // for to use all space in the screen
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.Red
                ),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Greeting3(
                name = "one",
                modifier = Modifier
                    .background(Color.Yellow)
                //.weight(2f)
            )
            Greeting3(
                name = "two",
                modifier = Modifier
                    .background(Color.Cyan)
                //.weight(1f)
            )
            Greeting3(
                name = "three",
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color.Blue
                    )
                //.background(Color.Blue)
                //.weight(1f)
            )
        }
    }
}


// if there are more of one parameter with a default value,
// modifier must be the first parameter
@Composable
fun Greeting3(modifier: Modifier = Modifier, name: String = "") {
    Text(
        text = name,
        modifier = modifier
    )
}