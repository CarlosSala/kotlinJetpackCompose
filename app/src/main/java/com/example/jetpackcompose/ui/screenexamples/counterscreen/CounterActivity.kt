package com.example.jetpackcompose.ui.screenexamples.counterscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcompose.ui.theme.CustomComposeTheme

class CounterActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomComposeTheme {
                /*    Scaffold { innerPadding ->

                           Counter(
                               Modifier.padding(innerPadding)
                           )
                    }*/
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 250,
    heightDp = 400
)
@Composable
fun CounterScreen() {

    var count by remember { mutableIntStateOf(0) }

    val viewModel: CounterViewModel = viewModel()
    count = viewModel.number

    CustomComposeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Count: $count!",
                fontSize = 20.sp,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Counter(buttonText = "Increment", action = {
                    viewModel.increment()
                    count = viewModel.number
                })
                Counter(buttonText = "Decrement", action = {
                    viewModel.decrement()
                    count = viewModel.number
                })
            }
        }
    }
}

@Composable
fun Counter(
    buttonText: String,
    action: () -> Unit,
) {
    Button(
        onClick = {
            action()
        }
    ) {
        Text(
            text = buttonText,
            fontSize = 20.sp,
        )
    }
}