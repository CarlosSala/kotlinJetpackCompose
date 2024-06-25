package com.example.jetpackcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            HorizontalPager()
            // MyApp()
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