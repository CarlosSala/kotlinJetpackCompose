package com.example.jetpackcompose.ui.screens.counterScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
                Scaffold() { innerPadding ->

                    IncrementNumber(
                        Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 350, heightDp = 350)
@Composable
fun MyPreview() {
    CustomComposeTheme {
        IncrementNumber()
    }
}

@Composable
fun IncrementNumber(modifier: Modifier = Modifier) {

    var count by remember { mutableIntStateOf(0) }

    val viewModel: CounterViewModel = viewModel()

    count = viewModel.number

    Column(
        modifier
            .fillMaxSize()
            .background(Color.Yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "My Count $count!",
            fontSize = 30.sp,
        )
        Spacer(
            modifier.height(16.dp)
        )
        Button(
            onClick = {
                viewModel.increment()
                count = viewModel.number
            }
        ) {
            Text(
                text = "Add one",
                fontSize = 20.sp,
            )
        }
    }
}