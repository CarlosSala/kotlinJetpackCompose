package com.example.jetpackcompose.ui.screenexamples.firestorescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CrudFireStoreScreen() {
    val userViewModel: UserViewModel = viewModel()


    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }

    val users by userViewModel.getUserList.collectAsState()
    val errorMessage by userViewModel.errorMessage.collectAsState()

    // Llamada a la función solo cuando se compone por primera vez
    LaunchedEffect(Unit) {
        userViewModel.getUsers()
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Add New User",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Top
        ) {
            Button(
                onClick = {
                    userViewModel.addUser(User(name = name, age = age))
                    name = ""
                    age = ""
                    userViewModel.getUsers()
                }
            ) {
                Text(text = "Add User")
            }

            Button(
                onClick = {

                    userViewModel.updateUser(id, User(id = id, name = name, age = age))
                    name = ""
                    age = ""
                    userViewModel.getUsers()
                },
            ) {
                Text(text = "Update User")
            }
        }


        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Users List",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if (errorMessage != null) {
            Text(
                text = "Error: $errorMessage",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
        } else {
            UserList(users, userViewModel) { userUpdate ->

                id = userUpdate.id.toString()
                name = userUpdate.name
                age = userUpdate.age
            }
        }
    }
}

@Composable
fun UserList(users: List<User>, viewModel: UserViewModel, onUpdate: (User) -> Unit) {

    LazyColumn {
        items(users) { user ->
            UserItem(user, viewModel) {
                onUpdate(it)
            }
            HorizontalDivider()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UserItem(user: User, viewModel: UserViewModel, onUpdate: (User) -> Unit) {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .combinedClickable(
                onClick = {

                    onUpdate(user)

                }, onLongClick = {
                    viewModel.deleteUser(user.id.toString())
                    viewModel.getUsers()
                }
            )
    ) {
        Text(text = "Name: ${user.name}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Age: ${user.age}", style = MaterialTheme.typography.bodyMedium)
    }
}