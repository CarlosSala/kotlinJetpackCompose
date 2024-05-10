package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jetpackcompose.ui.theme.CustomComposeTheme
import com.example.jetpackcompose.model.MediaItem
import com.example.jetpackcompose.model.getMedia

class MainActivity6 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomComposeTheme {

                MediaList2()
            }
        }
    }
}

@Composable
fun Greeting4(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview
@Composable
fun MediaList2() {
    LazyRow(
        contentPadding = PaddingValues(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(getMedia()) { item ->

            MediaListItem2(item)

            // MediaListItem()
        }
    }

}


// @Preview(showBackground = true)
@Composable
fun MediaListItem2(item: MediaItem) {

    Column(
        modifier = Modifier.width(200.dp)
    ) {
        Box(
            modifier = Modifier
                //.fillMaxWidth()
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
            if (item.type == MediaItem.Type.VIDEO) {
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