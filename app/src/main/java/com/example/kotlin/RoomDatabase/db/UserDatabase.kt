package com.example.kotlin.RoomDatabase.db

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun dao(): UserDao
}