package com.example.jetpackcompose.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackcompose.R
import kotlinx.coroutines.delay
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.compose.ui.draw.scale

@Composable
fun SplashScreen(navController: NavHostController) {

    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        visible = true
        delay(2000)
        navController.popBackStack()
        navController.navigate(MainScreen)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0099CC)) // Este es el color holo_blue_dark
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(animationSpec = tween(1000))
            ) {
                Image(
                    painter = painterResource(R.drawable.icon_512),
                    contentDescription = null,
                )
            }
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(animationSpec = tween(1000))
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = "TEST APP",
                    fontSize = 30.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


/*
@Composable
fun SplashScreen(navController: NavHostController) {

    LaunchedEffect(key1 = true) {

        delay(1500)
        navController.popBackStack()
        navController.navigate(MainScreen)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0099CC)) // Este es el color holo_blue_dark
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(R.drawable.icon_512),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = "TEST APP",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}*/
