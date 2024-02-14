package com.example.novoteste.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.novoteste.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAllUsers(): Flow<List<UserEntity>>

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUserById(id: Int): Flow<UserEntity>

    @Insert
    suspend fun insertUser(user: UserEntity)

    @Query("UPDATE user SET user = :user, email = :email WHERE id = :id")
    suspend fun updateUser(id: Int, email: String, user: String)

    @Delete
    suspend fun deleteUser(user: UserEntity)
}
