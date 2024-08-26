package com.example.hw_6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_6.databinding.ItemContactBinding

class ContactsAdapter : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    private val contacts = mutableListOf<String>()
    private var onContactClickListener: ((String) -> Unit)? = null

    fun submitList(list: List<String>) {
        contacts.clear()
        contacts.addAll(list)
        notifyDataSetChanged()
    }

    fun setOnContactClickListener(listener: (String) -> Unit) {
        onContactClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemContactBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
        holder.itemView.setOnClickListener {
            onContactClickListener?.invoke(contact)
        }
    }

    override fun getItemCount() = contacts.size

    class ViewHolder(private val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: String) {
            binding.tvName.text = contact
        }
    }
}