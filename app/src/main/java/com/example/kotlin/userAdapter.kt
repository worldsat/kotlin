package com.example.kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.databinding.ViewholderUserBinding

class userAdapter : RecyclerView.Adapter<userAdapter.Viewholder>() {
    lateinit var binding: ViewholderUserBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userAdapter.Viewholder {
        binding = ViewholderUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder()
    }

    override fun onBindViewHolder(holder: userAdapter.Viewholder, position: Int) {
        holder.setData(differ.currentList[position])
    }

    override fun getItemCount() = differ.currentList.size


    inner class Viewholder : RecyclerView.ViewHolder(binding.root) {
        fun setData(item: UsermModel) {
            binding.textView2.text = item.name + "-->" + item.family
        }
    }

    val defferCallback = object : DiffUtil.ItemCallback<UsermModel>() {
        override fun areItemsTheSame(oldItem: UsermModel, newItem: UsermModel): Boolean {
            return oldItem.name == newItem.name
        }


        override fun areContentsTheSame(oldItem: UsermModel, newItem: UsermModel): Boolean {
            return oldItem.equals(newItem)
        }

    }
    val differ = AsyncListDiffer(this, defferCallback)
}