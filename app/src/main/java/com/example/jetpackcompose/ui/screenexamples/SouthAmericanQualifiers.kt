package com.example.jetpackcompose.ui.screenexamples

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun SouthAmericanQualifiersScreenPreview() {
    SouthAmericanQualifiersScreen()
}

@Composable
fun SouthAmericanQualifiersScreen() {

    val headers = listOf("Team", "PJ", "PG", "PE", "PP", "Pts")
    val teams = listOf(
        listOf("Chile", "10", "5", "2", "3", "17"),
        listOf("Argentina", "10", "3", "2", "5", "11"),
        listOf("Brazil", "10", "2", "1", "7", "7")
    )

    LazyColumn {
        item {
            Row {
                headers.forEach { header ->
                    Text(
                        text = header,
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        items(teams) { team ->
            Row {
                team.forEach { data ->
                    Text(
                        text = data,
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}