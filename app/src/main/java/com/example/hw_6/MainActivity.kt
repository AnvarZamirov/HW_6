package com.example.hw_6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.hw_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.container, ContactsFragment())
            }
        }
    }

    fun showChatFragment(contactName: String) {
        val chatFragment = ChatFragment().apply {
            arguments = Bundle().apply {
                putString("contact_name", contactName)
            }
        }
        supportFragmentManager.commit {
            replace(R.id.container, chatFragment)
            addToBackStack(null)  // Добавляем в стек назад, чтобы можно было вернуться в список контактов
        }
    }
}