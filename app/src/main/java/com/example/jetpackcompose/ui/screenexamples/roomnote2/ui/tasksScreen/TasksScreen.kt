package com.example.jetpackcompose.ui.screenexamples.roomnote2.ui.tasksScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.jetpackcompose.ui.screenexamples.roomnote2.TasksTopAppBar
import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.model.Task
import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.source.local.TaskEntity

@Composable
fun TasksScreen(
    openDrawer: () -> Unit,
    modifier: Modifier = Modifier,
    taskViewModel: TaskViewModel = hiltViewModel(),
    addTaskViewModel: AddTaskViewModel = hiltViewModel()
) {

    /*    val context = LocalContext.current
        val application = context.applicationContext as Application
        val savedStateHandle = remember { SavedStateHandle() }

        val factory =
            remember { TaskViewModelFactory(application, defaultRepository, savedStateHandle) }
        val viewModel: TaskViewModel = viewModel(factory = factory)*/

    // viewModel: TaskViewModel = viewModel()

    var showCreateDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TasksTopAppBar(
                openDrawer = openDrawer,
                onFilterAllTasks = { },
                onFilterActiveTasks = { },
                onFilterCompletedTasks = { },
                onClearCompletedTasks = { }) {
            }
        },
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showCreateDialog = true }
            ) {
                Text("+")
            }
        }
    ) { padding ->

        val uiState by taskViewModel.uiState.collectAsStateWithLifecycle()
        val addTaskUiState by addTaskViewModel.uiState.collectAsStateWithLifecycle()

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            TextEntriesList(uiState.items)

            if (showCreateDialog) {
                CreateNoteDialog(
                    onDismiss = { showCreateDialog = false },
                    onSave = { title, body ->
                        // Save task here
                        addTaskViewModel.updateTitle(title)
                        addTaskViewModel.updateDescription(body)
                        // addTaskViewModel.saveTask(title, body)
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
fun TextEntriesList(tasksList: List<Task>) {

    // val textEntries by viewModel.allTaskEntity.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(1.dp),
    ) {
        items(tasksList) { item ->

            //ShowItems(item, viewModel)
            ShowItems(item)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowItems(
    task: Task,
    // viewModel: TaskViewModel
) {
    var showDialogUpdate by remember { mutableStateOf(false) }
    var noteToUpdate by remember { mutableStateOf<Task?>(null) }
    var showDialogDelete by remember { mutableStateOf(false) }
    var noteToDelete by remember { mutableStateOf<Task?>(null) }

    Card(
        modifier = Modifier
            .padding(1.dp)
            .fillMaxWidth(0.95f)
            .combinedClickable(
                onClick = {
                    noteToUpdate = task
                    showDialogUpdate = true
                },
                onLongClick = {
                    noteToDelete = task
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
                text = task.title,
                modifier = Modifier.padding(1.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = task.description,
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
                    /*             currentNote.title = title
                                 currentNote.description = description

                                 viewModel.updateTask(currentNote)*/
                    showDialogUpdate = false
                }
            )
        }
    }

    if (showDialogDelete) {
        noteToDelete?.let { currentNote ->
            ConfirmDeleteDialog(
                task = currentNote,
                onConfirm = {
                    // Handle the currentNote deletion here
                    // viewModel.deleteTask(currentNote)
                    showDialogDelete = false
                },
                onDismiss = { showDialogDelete = false }
            )
        }
    }
}

@Composable
fun NoteUpdateDialog(
    task: Task,
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
                var title by remember { mutableStateOf(task.title) }
                var body by remember { mutableStateOf(task.description) }

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
    task: Task,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = "Confirm Deletion")
        },
        text = {
            Text("Are you sure you want to delete the note ${task.title} ?")
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

/*
@Preview
@Composable
fun MyPreview() {
    TasksScreen()
}*/
