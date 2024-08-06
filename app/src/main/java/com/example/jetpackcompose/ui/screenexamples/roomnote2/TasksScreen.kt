package com.example.jetpackcompose.ui.screenexamples.roomnote2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TasksScreen() {

    var showCreateDialog by remember { mutableStateOf(false) }

    val viewModel: TaskViewModel = viewModel()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showCreateDialog = true }
            ) {
                Text("+")
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            TextEntriesList(viewModel)

            if (showCreateDialog) {
                CreateNoteDialog(
                    onDismiss = { showCreateDialog = false },
                    onSave = { title, body ->
                        // Save task here
                        viewModel.addTask(TaskEntity(title, body))
                        showCreateDialog = false
                    }
                )
            }
        }
    }
}


@Composable
fun CreateNoteDialog(onDismiss: () -> Unit, onSave: (String, String) -> Unit) {

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            shape = MaterialTheme.shapes.medium,
            // color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                var title by remember { mutableStateOf("") }
                var body by remember { mutableStateOf("") }

                Text(text = "New Note")
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = body,
                    onValueChange = { body = it },
                    label = { Text("Message") },
                    modifier = Modifier
                        .fillMaxHeight(0.7f)
                        .fillMaxWidth(),
                    maxLines = 10
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Button(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            onSave(title, body)
                        }
                    ) {
                        Text("Save")
                    }
                }
            }
        }
    }
}

@Composable
fun TextEntriesList(viewModel: TaskViewModel) {

    val textEntries by viewModel.allTaskEntity.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(1.dp),
    ) {
        items(textEntries) { item ->

            ShowItems(item, viewModel)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowItems(
    note: TaskEntity,
    viewModel: TaskViewModel
) {
    var showDialogUpdate by remember { mutableStateOf(false) }
    var noteToUpdate by remember { mutableStateOf<TaskEntity?>(null) }
    var showDialogDelete by remember { mutableStateOf(false) }
    var noteToDelete by remember { mutableStateOf<TaskEntity?>(null) }

    Card(
        modifier = Modifier
            .padding(1.dp)
            .fillMaxWidth(0.95f)
            .combinedClickable(
                onClick = {
                    noteToUpdate = note
                    showDialogUpdate = true
                },
                onLongClick = {
                    noteToDelete = note
                    showDialogDelete = true
                    // onLongClick = { viewModel.deleteNote(note)})
                    // viewModel.deleteNote(note)
                })
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 24.dp, horizontal = 32.dp)
        ) {
            Text(
                text = note.title,
                modifier = Modifier.padding(1.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = note.description,
                modifier = Modifier.padding(1.dp)
            )
        }
    }

    if (showDialogUpdate) {
        noteToUpdate?.let { currentNote ->
            NoteUpdateDialog(currentNote,
                onDismiss = { showDialogUpdate = false },
                onUpdate = { title, description ->
                    // update note here
                    currentNote.title = title
                    currentNote.description = description

                    viewModel.updateTask(currentNote)
                    showDialogUpdate = false
                }
            )
        }
    }

    if (showDialogDelete) {
        noteToDelete?.let { currentNote ->
            ConfirmDeleteDialog(
                note = currentNote,
                onConfirm = {
                    // Handle the currentNote deletion here
                    viewModel.deleteTask(currentNote)
                    showDialogDelete = false
                },
                onDismiss = { showDialogDelete = false }
            )
        }
    }
}

@Composable
fun NoteUpdateDialog(
    taskEntity: TaskEntity,
    onDismiss: () -> Unit,
    onUpdate: (String, String) -> Unit
) {

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            shape = MaterialTheme.shapes.medium,
            // color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                var title by remember { mutableStateOf(taskEntity.title) }
                var body by remember { mutableStateOf(taskEntity.description) }

                Text(text = "Update Note")
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = body,
                    onValueChange = { body = it },
                    label = { Text("Note") },
                    modifier = Modifier
                        .fillMaxHeight(0.7f)
                        .fillMaxWidth(),
                    maxLines = 10
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Button(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            onUpdate(title, body)
                        }
                    ) {
                        Text("Update")
                    }
                }
            }
        }
    }
}

@Composable
fun ConfirmDeleteDialog(
    note: TaskEntity,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = "Confirm Deletion")
        },
        text = {
            Text("Are you sure you want to delete the note ${note.title} ?")
        },
        confirmButton = {
            Button(onClick = onConfirm) {
                Text("Confirm")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}