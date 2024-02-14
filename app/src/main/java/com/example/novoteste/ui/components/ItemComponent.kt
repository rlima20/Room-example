package com.example.novoteste.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.novoteste.R
import com.example.novoteste.model.User

@Composable
fun ItemComponent(
    user: User,
    onUpdate: (user: User) -> Unit,
    onDelete: (user: User) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterVertically)
                .width(80.dp),
            text = user.userName,
        )
        Row {
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .size(45.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.purple_200),
                ),
                onClick = {
                    onUpdate(
                        User(
                            id = user.id,
                            userName = "Updated user 1234",
                            email = "email_atualizado@gmail.com",
                        ),
                    )
                },
            ) {
                Icon(
                    Icons.Filled.Edit,
                    contentDescription = "Button_update",
                    tint = Color.Black,
                )
            }
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .size(45.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.purple_200),
                ),
                onClick = { onDelete(user) },
            ) {
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "Button_delete",
                    tint = Color.Black,
                )
            }
        }
    }
}
