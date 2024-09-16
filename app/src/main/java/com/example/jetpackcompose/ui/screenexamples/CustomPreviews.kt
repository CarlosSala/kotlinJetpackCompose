package com.example.jetpackcompose.ui.screenexamples

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.theme.CustomComposeTheme

@Composable
fun MyComponent() {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
    ) {
        MyImage()
        MyTexts()
    }
}

@Composable
fun MyImage() {
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "my description",
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun MyTexts() {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        MyText(
            text = "hello friend",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            text = "second text",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle) {
    Text(
        text = text,
        color = color,
        style = style
    )
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent() {
    CustomComposeTheme {
        MyComponent()
    }
}