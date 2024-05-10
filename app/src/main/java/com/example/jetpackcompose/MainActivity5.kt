package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jetpackcompose.model.MediaItem.*
import com.example.jetpackcompose.ui.theme.CustomComposeTheme
import com.example.jetpackcompose.model.MediaItem
import com.example.jetpackcompose.model.getMedia

class MainActivity5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomComposeTheme {

                // ButtonText()
                // MediaItem()
                MediaList()
            }
        }
    }
}

// @Preview(showBackground = true, widthDp = 400, heightDp = 200)
@Composable
fun ButtonText() {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            // text = stringResource(R.string.my_button),
            text = stringResource(id = R.string.lorem),
            //"My Button",
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
            // onTextLayout, to check
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

@Preview
@Composable
fun MediaList() {
    LazyColumn(
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(getMedia()) { item ->

            MediaListItem(item)

            // MediaListItem()
        }
    }

}

// @Preview(showBackground = true)
@Composable
fun MediaListItem(item: MediaItem) {

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
            // .background(color = Color.Red)
        ) {

            AsyncImage(
                // "https://loremflickr.com/400/400/cat?lock=1"
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.thumb)
                    //.transformations(CircleCropTransformation())
                    .crossfade(2000)
                    .build(),
                contentDescription = null,
                // modifier = Modifier.clip(RoundedCornerShape(4.dp))
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            if (item.type == Type.VIDEO) {
                Icon(
                    imageVector = Icons.Default.PlayCircleOutline,
                    contentDescription = null,
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .size(92.dp)
                        .align(Alignment.Center)
                )
            }
            // charge icons from resources
            /*    Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    tint = Color.Green
                )*/

        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        ) {

            Text(
                text = item.title,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

// if there are more of one parameter with a default value,
// modifier must be the first parameter
@Composable
fun GreetingPreview4(name: String, modifier: Modifier = Modifier) {

    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}