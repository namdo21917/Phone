package com.example.phone

import Contact
import ContactVerticalAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phone.databinding.ContactListVerticalBinding

class ContactsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var contacts: List<Contact>
    private lateinit var adapter: ContactVerticalAdapter
    private lateinit var binding: ContactListVerticalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContactListVerticalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.contacts_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        contacts = generateContacts()
//        adapter = ContactAdapter(contacts)
//        recyclerView.adapter = adapter
    }

    private fun generateContacts(): List<Contact> {
        val contacts = ArrayList<Contact>()

        contacts.add(Contact("Nam", "0123456789"))
        contacts.add(Contact("Tan", "0988997972"))
        contacts.add(Contact("Quang", "0897997821"))
        contacts.add(Contact("Adam", "0846000452"))
        contacts.add(Contact("Eva", " 0458325466"))
        contacts.add(Contact("Kien", "0865482354"))
        contacts.add(Contact("Vinh", "0988997972"))
        contacts.add(Contact("Quang", "0988997972"))
        contacts.add(Contact("Duc", "0988997972"))
        contacts.add(Contact("Minh", "0988997972"))

        return contacts
    }
}