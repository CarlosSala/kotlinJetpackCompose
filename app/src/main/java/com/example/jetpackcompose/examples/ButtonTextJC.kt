package com.example.jetpackcompose.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R

@Preview(showBackground = true, widthDp = 400, heightDp = 200)
@Composable
fun ButtonTextJC() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(2.dp, Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.lorem),
            color = Color.DarkGray,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            letterSpacing = 5.sp,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Justify,
            lineHeight = 2.em,
            maxLines = 4,
            softWrap = false,
            overflow = TextOverflow.Ellipsis,
            onTextLayout = {},
            // style, to abstract the style
            style = MaterialTheme.typography.bodyLarge.copy(
                shadow = Shadow(
                    offset = Offset(5f, 5f),
                    blurRadius = 10f,
                    color = Color.Black.copy(alpha = 0.6f)
                )
            ),
            // the order of modifier matters
            modifier = Modifier
                .clickable { }
                .background(Color.Cyan)
                .border(width = 2.dp, color = Color.Red)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}