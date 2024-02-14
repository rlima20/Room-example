package com.example.novoteste.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.example.novoteste.constants.userInsert
import com.example.novoteste.constants.userUpdate
import com.example.novoteste.database.UserDatabase
import com.example.novoteste.ui.theme.NovoTesteTheme
import com.example.novoteste.viewmodel.UsersViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = Room.databaseBuilder(
            this,
            UserDatabase::class.java,
            "user_database",
        ).build()
        val dao = database.userDao()
        val viewModel = UsersViewModel(dao)

        setContent {
            HomeScreen(viewModel)
        }
    }
}

@Composable
fun HomeScreen(viewModel: UsersViewModel) {
    NovoTesteTheme {
        val user by viewModel.userState.collectAsState()
        val listOfUsers by viewModel.listOfUsersState.collectAsState()

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
        ) {
            Column {
                Button(
                    modifier = Modifier.padding(16.dp).height(50.dp).fillMaxSize(),
                    onClick = { viewModel.insertUser(userInsert) },
                ) { Text(text = "Button_insert") }
                Button(
                    modifier = Modifier.padding(16.dp).height(50.dp).fillMaxSize(),
                    onClick = { viewModel.updateUser(userUpdate) },
                ) { Text(text = "Button_update") }
                Button(
                    modifier = Modifier.padding(16.dp).height(50.dp).fillMaxSize(),
                    onClick = { viewModel.getUserById(5) },
                ) { Text(text = "Button_getUserById") }
                Button(
                    modifier = Modifier.padding(16.dp).height(50.dp).fillMaxSize(),
                    onClick = { viewModel.deleteUser(userUpdate) },
                ) { Text(text = "Button_deleteUser") }
            }
        }
    }
}
