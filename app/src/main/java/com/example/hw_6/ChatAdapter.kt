package com.example.hw_6

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.marginLeft
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_6.databinding.ItemChatBinding

class ChatAdapter() :
    ListAdapter<Model, ChatAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemChatBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.GRAY)
        }
        val layoutParams = holder.itemView.layoutParams as ViewGroup.MarginLayoutParams

        if (position % 2 != 0) {
            layoutParams.marginStart = 150.dpToPx(holder.itemView.context)
            layoutParams.marginEnd = 0
        } else {
            layoutParams.marginStart = 0
            layoutParams.marginEnd = 16.dpToPx(holder.itemView.context)
        }

        holder.itemView.layoutParams = layoutParams
    }


    class ViewHolder(private val binding: ItemChatBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun bind(model: Model?) {
            binding.apply {
                tvText.text = model?.text
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Model>() {
        override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem.text == newItem.text
        }

        override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem == newItem
        }
    }
}