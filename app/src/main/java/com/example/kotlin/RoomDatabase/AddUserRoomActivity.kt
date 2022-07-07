package com.example.kotlin.RoomDatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.kotlin.R
import com.example.kotlin.RoomDatabase.db.UserDatabase
import com.example.kotlin.RoomDatabase.db.UserEntity
import com.example.kotlin.databinding.ActivityAddUserRoomBinding

class AddUserRoomActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddUserRoomBinding

    private val userdb: UserDatabase by lazy {
        Room.databaseBuilder(this, UserDatabase::class.java, "name of database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    private lateinit var user: UserEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            saveBtn.setOnClickListener {
                val name = nameEdt.text.toString().trim()
                val family = familyEdt.text.toString().trim()


                if (name.isNotEmpty() || family.isNotEmpty()) {
                    user = UserEntity(0, name, family.toInt())
                    userdb.dao().insertUser(user)
                    finish()

                } else {
                    Toast.makeText(this@AddUserRoomActivity, "error", Toast.LENGTH_SHORT).show()
                }
            }
        }
        var name: String
        intent.extras?.let {
            name = it.getString("de").toString()
            name = userdb.dao().getUser(0).userName
        }

    }
}