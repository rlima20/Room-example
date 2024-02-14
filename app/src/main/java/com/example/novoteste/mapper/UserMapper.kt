package com.example.novoteste.mapper

import com.example.novoteste.entity.UserEntity
import com.example.novoteste.model.User

class UserMapper {
    fun toMap(listOfUserEntity: List<UserEntity>): List<User> {
        val listOfUser = mutableListOf<User>()
        listOfUserEntity.forEach {
            listOfUser.add(
                User(
                    id = it.id,
                    user = it.user,
                    email = it.email,
                ),
            )
        }
        return listOfUser
    }

    fun toMap(userEntity: UserEntity): User {
        return User(
            id = userEntity.id,
            user = userEntity.user,
            email = userEntity.email,
        )
    }

    fun toMap(user: User): UserEntity {
        return UserEntity(
            id = user.id,
            user = user.user,
            email = user.email,
        )
    }
}
