package com.example.novoteste.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.novoteste.AppApplication
import com.example.novoteste.R
import com.example.novoteste.database.Database
import com.example.novoteste.model.User
import com.example.novoteste.viewmodel.ViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: ViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val listOfUsers by viewModel.listState.collectAsState()
            val user = User(
                userName = "New user 1234",
                email = "new_user@gmail.com",
            )
            Scaffold(
                content = { content ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(content),
                    ) {
                        LazyColumnComponent(
                            list = listOfUsers.map { it },
                            onUpdate = { viewModel.update(it) },
                            onDelete = { viewModel.delete(it) },
                        )
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        backgroundColor = colorResource(id = R.color.teal_200),
                        modifier = Modifier
                            .padding(16.dp)
                            .size(50.dp),
                        onClick = { viewModel.insert(user) },
                    ) {
                        Icon(Icons.Filled.Add, null)
                    }
                },
            )
        }
    }
}
