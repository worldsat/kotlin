package com.example.kotlin.RoomDatabase.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kotlin.RoomDatabase.utils.Constants

@Entity(tableName = Constants.USER_TABLE)
class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val userId: Int,
    @ColumnInfo(name="User_name")
    val userName: String,
    val userAge: Int
)