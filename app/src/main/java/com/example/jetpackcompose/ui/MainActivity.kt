package com.example.jetpackcompose.ui

import android.os.Bundle
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
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.jetpackcompose.ui.screenExamples.room.NoteDatabase
import com.example.jetpackcompose.ui.screenExamples.room.NoteEntity
import com.example.jetpackcompose.ui.screenExamples.room.NoteRepository
import com.example.jetpackcompose.ui.screenExamples.room.NoteViewModel
import com.example.jetpackcompose.ui.theme.CustomComposeTheme

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java,
            name = "note.db"
        ).build()
    }
    private val viewModel by viewModels<NoteViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return NoteViewModel(NoteRepository(db)) as T
                }
            }
        }
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // HorizontalPager()
            // TextApp(viewModel = textViewModel)
            // TextApp2()
            CustomComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var name by remember {
                        mutableStateOf("")
                    }
                    var body by remember {
                        mutableStateOf("")
                    }
                    val note = NoteEntity(
                        noteName = name,
                        noteBody = body
                    )
                    var noteList by remember {
                        mutableStateOf(listOf<NoteEntity>())
                    }
                    viewModel.getNotes().observe(this) {
                        noteList = it
                    }
                    Column(
                        Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Button(onClick = {
                            viewModel.upsertNote(note)
                        }) {
                            Text(text = "set data")
                        }
                        TextField(value = name, onValueChange = { name = it }, placeholder = {
                            Text(
                                text = "name"
                            )
                        })
                        TextField(value = body, onValueChange = { body = it }, placeholder = {
                            Text(
                                text = "body"
                            )
                        })

                        LazyColumn {
                            items(noteList) { note ->
                                Column(Modifier.clickable {
                                    viewModel.deleteNote(note)
                                }) {
                                    Text(text = "Name: ${note.noteName}")
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(text = "Body: ${note.noteBody}")
                                    Divider(
                                        Modifier
                                            .fillMaxWidth()
                                            .padding(6.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
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