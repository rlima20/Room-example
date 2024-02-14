package com.example.novoteste.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.novoteste.dao.Dao
import com.example.novoteste.entity.Entity
import com.example.novoteste.database.Database as LocalClass

@Database(
    entities = [Entity::class],
    version = 1,
    exportSchema = false,
)
abstract class Database : RoomDatabase() {
    abstract fun dao(): Dao

    companion object {
        private lateinit var db: LocalClass

        fun getInstance(context: Context): LocalClass {
            if (::db.isInitialized) return db

            db = Room.databaseBuilder(
                context,
                LocalClass::class.java,
                "user_database",
            ).build()

            return db
        }
    }
}
