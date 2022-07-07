package com.example.kotlin.RoomDatabase.db

import androidx.room.*
import com.example.kotlin.RoomDatabase.utils.Constants

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

    @Update
    fun updateUser(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)

    @Query("select * from "+Constants.USER_TABLE+ " Order by userId Desc")
    fun getAllUser():MutableList<UserEntity>

    @Query("select * from "+Constants.USER_TABLE+" where userId like :id")
    fun getUser(id: Int):UserEntity

    @Query("delete from "+Constants.USER_TABLE)
    fun getUser()
}