package com.example.kotlin.Hilt.roomInHilt.Repository

import com.example.kotlin.Hilt.roomInHilt.db.NoteDao
import com.example.kotlin.Hilt.roomInHilt.db.NoteModel
import javax.inject.Inject

class DbRepository @Inject constructor(private val dao: NoteDao) {

    fun saveNote(entity: NoteModel) = dao.saveNote(entity)


    fun getAllNotes() = dao.getAllNote()

}