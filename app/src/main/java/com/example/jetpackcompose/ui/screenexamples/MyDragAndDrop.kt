import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.model.getMedia
import com.example.jetpackcompose.ui.screenexamples.MediaListItem
import org.burnoutcrew.reorderable.ReorderableItem
import org.burnoutcrew.reorderable.detectReorderAfterLongPress
import org.burnoutcrew.reorderable.rememberReorderableLazyListState
import org.burnoutcrew.reorderable.reorderable


@Composable
fun MyDragAndDrop() {
    var items by remember { mutableStateOf(getMedia()) }
    val reorderableState = rememberReorderableLazyListState(
        onMove = { from, to ->
            items = items.toMutableList().apply {
                add(to.index, removeAt(from.index))
            }
        }
    )

    LazyColumn(
        state = reorderableState.listState,
        modifier = Modifier
            .fillMaxSize()
            .reorderable(reorderableState)
            .detectReorderAfterLongPress(reorderableState)
    ) {
        itemsIndexed(items, key = { _, item -> item.id }) { _, item ->
            ReorderableItem(reorderableState, key = item.id) { isDragging ->
                val elevation by animateDpAsState(if (isDragging) 8.dp else 0.dp, label = "")

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