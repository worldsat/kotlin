package com.example.kotlin.Hilt.roomInHilt.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlin.Hilt.NOTE_TABLE

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNote(note: NoteModel)

    @Query("Select * from $NOTE_TABLE")
    fun getAllNote(): MutableList<NoteModel>
}