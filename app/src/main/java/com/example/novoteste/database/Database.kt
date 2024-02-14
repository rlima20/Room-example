package com.example.novoteste.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.novoteste.dao.Dao
import com.example.novoteste.entity.Entity

@Database(
    entities = [Entity::class],
    version = 1,
    exportSchema = false,
)
abstract class Database : RoomDatabase() {
    abstract fun dao(): Dao
}
