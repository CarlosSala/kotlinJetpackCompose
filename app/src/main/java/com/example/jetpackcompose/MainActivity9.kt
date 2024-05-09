package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.CustomComposeTheme

class MainActivity9 : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomComposeTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                /*        Row {
                                            Text(text = stringResource(id = R.string.app_name))
                                            Spacer(modifier = Modifier.width(16.dp))
                                            Icon(
                                                imageVector = Icons.Default.ElectricBolt,
                                                contentDescription = null
                                            )
                                        }*/
                                Text(text = stringResource(id = R.string.app_name))
                            },
                            navigationIcon = {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = null
                                    )
                                }
                            },
                            actions = {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = null
                                    )
                                }
                                IconButton(onClick = { /*TODO*/ }) {

                                    Icon(
                                        imageVector = Icons.Default.Share,
                                        contentDescription = null
                                    )
                                }
                            }
                        )
                    }
                ) { paddingValues ->

                    MediaList4(modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}

// @Preview
@Composable
fun MediaList4(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(4.dp),
        // columns = GridCells.Fixed(2)
        columns = GridCells.Adaptive(150.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier

    ) {
        items(getMedia()) { item ->

            MediaListItem3(item)
        }
    }
}