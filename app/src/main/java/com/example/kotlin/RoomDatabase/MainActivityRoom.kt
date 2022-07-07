package com.example.kotlin.RoomDatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.kotlin.R
import com.example.kotlin.RoomDatabase.db.UserDatabase
import com.example.kotlin.databinding.ActivityMainRoomBinding

class MainActivityRoom : AppCompatActivity() {
    lateinit var binding: ActivityMainRoomBinding

    private val userdb: UserDatabase by lazy {
        Room.databaseBuilder(this, UserDatabase::class.java, "name of database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    private val userAdapter by lazy {
        userAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            addBtn.setOnClickListener {
                startActivity(Intent(this@MainActivityRoom, AddUserRoomActivity::class.java))
            }
            userAdapter.differ.submitList(userdb.dao().getAllUser())

        }

    }

    override fun onResume() {
        super.onResume()
        checkItems()
    }
    private fun checkItems() {
        binding.apply {
            if (userdb.dao().getAllUser().isNotEmpty()) {
                view.visibility = View.VISIBLE
                setupRecycler()
            } else {
                view.visibility = View.GONE
            }
        }

    }

    private fun setupRecycler() {
        binding.view.apply {
            layoutManager = LinearLayoutManager(this@MainActivityRoom)
            adapter = userAdapter
        }
    }
}