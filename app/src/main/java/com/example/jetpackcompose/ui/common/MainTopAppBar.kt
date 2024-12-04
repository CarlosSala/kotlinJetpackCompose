package com.example.jetpackcompose.ui.common

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.screenexamples.styles.MyThemes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    onTitleChange: String,
    selectedTheme: (ColorScheme) -> Unit,
    onBack: () -> Unit
) {
    var menuExpanded by remember { mutableStateOf(false) }
    val subMenuExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        // windowInsets = WindowInsets(top = 0.dp),
        modifier = modifier, //.windowInsetsTopHeight(WindowInsets(top = 0)),
        colors = TopAppBarDefaults.topAppBarColors(containerColor = color),
        title = {
            /*        Row {
                        Text(text = stringResource(id = R.string.app_name))
                        Spacer(modifier = Modifier.width(16.dp))
                        Icon(
                            imageVector = Icons.Default.ElectricBolt,
                            contentDescription = null
                        )
                    }*/
            // Text(text = stringResource(id = R.string.app_name))
            Text(
                text = onTitleChange,
                fontSize = 18.sp
            )
        },
        navigationIcon = {
            AppBarAction(
                imageVector = Icons.Default.ArrowBackIosNew,
                onClick = { onBack() }
            )
        },
        actions = {

            AppBarAction(imageVector = Icons.Default.Search, onClick = {/*TODO*/ })
            AppBarAction(imageVector = Icons.Default.Share, onClick = {/*TODO*/ })
            AppBarAction(imageVector = Icons.Default.MoreVert, onClick = { menuExpanded = true })
            DropdownMenu(
                expanded = menuExpanded,
                onDismissRequest = { menuExpanded = false }
            ) {
                MyThemes().listColorSchemes.entries.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(item.key) },
                        onClick = {
                            // Handle theme selection
                            selectedTheme(item.value)
                            menuExpanded = false
                        }
                    )

                }
                /*  DropdownMenuItem(
                      text = { Text(text = "Option 1") },
                      onClick = {
                          menuExpanded = false
                      }
                  )
                  DropdownMenuItem(
                      text = { Text(text = "Option 2") },
                      onClick = {
                          menuExpanded = false
                      }
                  )
                  DropdownMenuItem(
                      text = { Text(text = "Option 3") },
                      onClick = {
                          // menuExpanded = false
                          subMenuExpanded = !subMenuExpanded
                      }
                  )*/
                if (subMenuExpanded) {
                    /*   SubMenuContent(
                           onDismiss = { subMenuExpanded = false },
                           items = listOf("sub option 1.1", "sub option 1.2")
                       )*/
                }
            }
        }
    )
}

@Composable
private fun AppBarAction(
    imageVector: ImageVector,
    onClick: () -> Unit
) {

    IconButton(onClick = onClick) {
        Icon(
            imageVector = imageVector,
            contentDescription = null
        )
    }
}

/*
@Composable
fun SubMenuContent(onDismiss: () -> Unit, items: List<String>) {
    DropdownMenu(
        modifier = Modifier.offset(16.dp),
        expanded = true,
        onDismissRequest = onDismiss
    ) {
        items.forEach { item ->
            DropdownMenuItem(
                text = { Text(item) },
                onClick = {
                    // Acción para submenú
                    onDismiss()
                }
            )
        }
    }
}*/
