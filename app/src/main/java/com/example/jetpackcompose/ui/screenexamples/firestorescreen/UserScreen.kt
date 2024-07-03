package com.example.jetpackcompose.ui.screenexamples.firestorescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserScreen() {

    val userViewModel: UserViewModel = viewModel()

    val users by userViewModel.users.collectAsState()
    val errorMessage by userViewModel.errorMessage.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = {
            userViewModel.addUser(User("Ada", "Lovelace", 1815))
        }) {
            Text(text = "Add User")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Users:")

        if (errorMessage != null) {
            Text(text = "Error: $errorMessage", color = MaterialTheme.colorScheme.error)
        } else {
            UserList(users)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            userViewModel.getUsers()
        }) {
            Text(text = "Load Users")
        }
    }
}

@Composable
fun UserList(users: List<User>) {
    Column {
        users.forEach { user ->
            Text(text = "Name: ${user.first} ${user.last}, Born: ${user.born}")
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}