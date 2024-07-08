package com.example.jetpackcompose.ui.screenexamples.mutablestate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.CustomComposeTheme

class MutableStateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomComposeTheme {

                /*  val (value, onValueChange) = rememberSaveable { mutableStateOf("") }
                           StateSample(
                               value = value,
                               onValueChange = onValueChange
                           )*/
            }
        }
    }
}


@Preview(
    showBackground = true,
    widthDp = 400,
    heightDp = 400
)
@Composable
fun ViewMutableStateExample() {

    // mutable variable
    // var text by remember { mutableStateOf("") }

    // mutable and persistent variable
    var text by rememberSaveable { mutableStateOf("") }

    MutableStateExample(
        value = text
    ) {
        text = it
    }
}

@Composable
fun MutableStateExample(value: String, onValueChange: (String) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 64.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = value,
            onValueChange = { textChanging ->
                onValueChange(textChanging)
            },
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(8.dp),
            text = value,
        )
        Button(
            onClick = {
                onValueChange("")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            enabled = value.isNotEmpty()
        ) {
            Text(
                text = "Clear"
            )
        }
    }
}