package com.example.novoteste.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.novoteste.entity.Entity
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM user")
    fun getAll(): Flow<List<Entity>>

    @Query("SELECT * FROM user WHERE id = :id")
    fun getById(id: Int): Flow<Entity>

    @Insert
    suspend fun insert(user: Entity)

    @Query("UPDATE user SET user = :user, email = :email WHERE id = :id")
    suspend fun update(id: Int, email: String, user: String)

    @Delete
    suspend fun delete(user: Entity)
}
