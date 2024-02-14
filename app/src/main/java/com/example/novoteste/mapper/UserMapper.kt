package com.example.novoteste.mapper

import com.example.novoteste.entity.Entity
import com.example.novoteste.model.User

class UserMapper {
    fun toMap(userEntity: Entity): User {
        return User(
            id = userEntity.id,
            userName = userEntity.user,
            email = userEntity.email,
        )
    }

    fun toMap(user: User): Entity {
        return Entity(
            id = user.id,
            user = user.userName,
            email = user.email,
        )
    }
}
