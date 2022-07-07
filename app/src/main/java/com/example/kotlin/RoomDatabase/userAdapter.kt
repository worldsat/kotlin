package com.example.kotlin.RoomDatabase

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.RoomDatabase.db.UserEntity
import com.example.kotlin.databinding.ViewholderUserBinding

class userAdapter : RecyclerView.Adapter<userAdapter.Viewholder>() {
    lateinit var binding: ViewholderUserBinding

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userAdapter.Viewholder {
        binding = ViewholderUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return Viewholder()
    }

    override fun onBindViewHolder(holder: userAdapter.Viewholder, position: Int) {
        holder.setData(differ.currentList[position])
    }

    override fun getItemCount() = differ.currentList.size


    inner class Viewholder : RecyclerView.ViewHolder(binding.root) {
        fun setData(item: UserEntity) {
            binding.textView2.text = item.userName + "<-->" + item.userAge

            binding.root.setOnClickListener {
//                val intent=Intent(context,)
            }
        }
    }

    val defferCallback = object : DiffUtil.ItemCallback<UserEntity>() {
        override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem.userId == newItem.userId
        }


        override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem.equals(newItem)
        }

    }
    val differ = AsyncListDiffer(this, defferCallback)
}