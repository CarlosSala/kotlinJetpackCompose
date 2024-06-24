package com.example.jetpackcompose.ui

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.jetpackcompose.ui.screenExamples.room.NoteDatabase
import com.example.jetpackcompose.ui.screenExamples.room.NoteEntity
import com.example.jetpackcompose.ui.screenExamples.room.NoteRepository
import com.example.jetpackcompose.ui.screenExamples.room.NoteViewModel
import com.example.jetpackcompose.ui.theme.CustomComposeTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: NoteViewModel = viewModel()
            MyApp(viewModel)
        }

    }
}

@Composable
fun MyApp(viewModel: NoteViewModel) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextEntryInput(viewModel)
        Spacer(modifier = Modifier.height(16.dp))
        TextEntriesList(viewModel)
    }
}

@Composable
fun TextEntryInput(viewModel: NoteViewModel) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter text") },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                viewModel.insert(text)
                text = ""
            }
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TextEntriesList(viewModel: NoteViewModel) {
    val textEntries by viewModel.allTextEntries.collectAsState(initial = emptyList())

    LazyColumn {
        items(textEntries) { entry ->
            Text(
                text = entry.noteName,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

/*    @Composable
    fun TextApp2() {
        var textEntities by remember { mutableStateOf<List<TextEntity>>(emptyList()) }


        TextList(textEntities)
    }*/


/* @Composable
 fun TextApp(viewModel: TextViewModel) {
     var text by remember { mutableStateOf("") }
     val textList by viewModel.allTexts.collectAsState(initial = emptyList())

     Column(modifier = Modifier.padding(16.dp)) {
         OutlinedTextField(
             value = text,
             onValueChange = { text = it },
             label = { Text("Enter text") },
             modifier = Modifier.fillMaxWidth()
         )
         Spacer(modifier = Modifier.height(8.dp))
         Button(onClick = {
             if (text.isNotBlank()) {
                 viewModel.insert(text)
                 text = ""
             }
         }) {
             Text("Save")
         }
         Spacer(modifier = Modifier.height(16.dp))
         TextList(textList)
     }
 }*/

/*   @Composable
   fun TextList(textEntities: List<TextEntity>) {

       LazyColumn {
           items(textEntities) { textEntity ->
               Text(textEntity.text, modifier = Modifier.padding(8.dp))
           }
       }
   }*/