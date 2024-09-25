package com.example.jetpackcompose.ui.screenexamples

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.model.getMedia
import org.burnoutcrew.reorderable.*
@Composable
fun LazyVerticalGridDragAndDrop() {
    var items by remember { mutableStateOf(getMedia()) }

    // Estado de reordenamiento para LazyVerticalGrid
    val reorderableState = rememberReorderableLazyGridState(
        onMove = { from, to ->
            items = items.toMutableList().apply {
                add(to.index, removeAt(from.index))
            }
        }
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),  // Configura el número de columnas
        state = reorderableState.gridState,
        modifier = Modifier
            .fillMaxSize()
            .reorderable(reorderableState)
            .detectReorderAfterLongPress(reorderableState)
    ) {
        itemsIndexed(items, key = { _, item -> item.id }) { index, item ->
            ReorderableItem(reorderableState, key = item.id) { isDragging ->
                val elevation by animateDpAsState(if (isDragging) 8.dp else 0.dp)

                MediaListItem(
                    item = item,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .shadow(elevation)
                        .background(Color.White, RoundedCornerShape(8.dp))
                )
            }
        }
    }
}
