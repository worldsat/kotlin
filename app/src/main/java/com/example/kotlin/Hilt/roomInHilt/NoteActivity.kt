package com.example.kotlin.Hilt.roomInHilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.Hilt.roomInHilt.Repository.DbRepository
import com.example.kotlin.Hilt.roomInHilt.db.NoteModel
import com.example.kotlin.R
import com.example.kotlin.databinding.ActivityNoteBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityNoteBinding

    @Inject
    lateinit var repository: DbRepository

    @Inject
    lateinit var noteAdapter: NoteAdapter

    @Inject
    lateinit var entity: NoteModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            button.setOnClickListener {
                entity.id = 0
                entity.title = editTextTextPersonName.text.toString()
                repository.saveNote(entity)
                editTextTextPersonName.setText("")
                noteAdapter.differ.submitList(repository.getAllNotes())
            }

            //get data
            noteAdapter.differ.submitList(repository.getAllNotes())
            view.apply {
                layoutManager=LinearLayoutManager(this@NoteActivity)
                adapter=noteAdapter
            }
        }

    }
}