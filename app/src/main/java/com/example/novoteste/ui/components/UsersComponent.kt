package com.example.novoteste.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.novoteste.model.User

@Composable
fun LazyColumnComponent(
    list: List<User>,
    onUpdate: (user: User) -> Unit = {},
    onDelete: (user: User) -> Unit = {},
) {
    LazyColumn(
        modifier = Modifier
            .padding(bottom = 100.dp)
            .fillMaxWidth(),
    ) {
        items(list.size) { index ->
            ItemComponent(
                user = list[index],
                onUpdate = { onUpdate(it) },
                onDelete = { onDelete(it) },
            )
        }
    }
}
