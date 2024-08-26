package com.example.hw_6

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw_6.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private val chatAdapter = ChatAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvChat.layoutManager = LinearLayoutManager(requireContext())
        binding.rvChat.adapter = chatAdapter
        setupListeners()


        val contactName = arguments?.getString("contact_name")
        binding.tvContactName.text = contactName
    }

    private fun setupListeners() {
        binding.btnChat.setOnClickListener {
            val messageText = binding.etChat.text.toString()
            if (messageText.isNotEmpty()) {
                val message = Model(text = messageText, isSentByUser = true)
                addMessage(message)
                binding.etChat.text.clear()
            }
        }
    }

    private fun addMessage(message: Model) {
        val currentList = chatAdapter.currentList.toMutableList()
        currentList.add(message)
        chatAdapter.submitList(currentList)
    }
}