package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.databinding.ActivityMain3Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding
    val userAdapter by lazy { userAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.setText("test")

        userAdapter.differ.submitList(myList())
        binding.view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity2)
            adapter = userAdapter
        }
    }

    fun myList(): MutableList<UsermModel> {
        var users: MutableList<UsermModel> = mutableListOf()
        users.add(UsermModel("mohsen", "jamali"))
        users.add(UsermModel("mohsen2", "jamali2"))
        users.add(UsermModel("mohsen3", "jamali3"))

        return users

    }
}