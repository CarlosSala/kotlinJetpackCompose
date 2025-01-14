package com.example.jetpackcompose.ui.screenexamples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout


@Preview(showBackground = true)
@Composable
fun ConstraintJC() {

    ConstraintLayout(Modifier.fillMaxSize()) {

        val (boxRed, boxBlue, boxMagenta, boxYellow, boxGreen) = createRefs()
        val topGuide = createGuidelineFromTop(0.2f)
        val startGuide = createGuidelineFromStart(0.2f)

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(boxBlue.start)
            })
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                top.linkTo(parent.top)
                start.linkTo(boxRed.end)
                end.linkTo(parent.end)
            })

        createHorizontalChain(boxRed, boxBlue, chainStyle = ChainStyle.Packed)

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            })
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Box(modifier = Modifier
            .size(100.dp)
            //.width(100.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                //  height = Dimension.fillToConstraints
                top.linkTo(boxYellow.bottom)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end, margin = 16.dp)
            })
    }
}