package com.example.hw_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw_6.databinding.FragmentContactsBinding

class ContactsFragment : Fragment() {

    private lateinit var binding: FragmentContactsBinding
    private val contactsAdapter = ContactsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvContacts.layoutManager = LinearLayoutManager(requireContext())
        binding.rvContacts.adapter = contactsAdapter


        val contacts = listOf("John Doe", "Jane Smith", "Alice Johnson","Messi", "Arthur","Cristiano","Sadyr Japarov","Janna","Mom","Dad","Tahmina","Mars","Dari")
        contactsAdapter.submitList(contacts)

        contactsAdapter.setOnContactClickListener { contactName ->

            (activity as? MainActivity)?.showChatFragment(contactName)
        }
    }
}