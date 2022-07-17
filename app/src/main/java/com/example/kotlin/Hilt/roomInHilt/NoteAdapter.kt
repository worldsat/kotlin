package com.example.kotlin.Hilt.roomInHilt

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.Hilt.roomInHilt.db.NoteModel
import com.example.kotlin.RoomDatabase.db.UserEntity
import com.example.kotlin.databinding.ViewholderUserBinding
import javax.inject.Inject

class NoteAdapter @Inject constructor() : RecyclerView.Adapter<NoteAdapter.Viewholder>() {
    lateinit var binding: ViewholderUserBinding

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.Viewholder {
        binding = ViewholderUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return Viewholder()
    }

    override fun onBindViewHolder(holder: NoteAdapter.Viewholder, position: Int) {
        holder.setData(differ.currentList[position])
    }

    override fun getItemCount() = differ.currentList.size


    inner class Viewholder : RecyclerView.ViewHolder(binding.root) {
        fun setData(item: NoteModel) {
            binding.textView2.text = item.title + "<-->" + item.id

            binding.root.setOnClickListener {
//                val intent=Intent(context,)
            }
        }
    }

    val defferCallback = object : DiffUtil.ItemCallback<NoteModel>() {
        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem.id == newItem.id
        }


        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem.equals(newItem)
        }

    }
    val differ = AsyncListDiffer(this, defferCallback)
}