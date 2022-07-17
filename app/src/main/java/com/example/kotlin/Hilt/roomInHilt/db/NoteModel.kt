package com.example.kotlin.Hilt.roomInHilt.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kotlin.Hilt.NOTE_TABLE
import java.io.StringBufferInputStream

@Entity(tableName = NOTE_TABLE)
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    var title:String=""

)



