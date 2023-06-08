package com.example.phone

import Contact
import ContactVerticalAdapter
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phone.databinding.ContactListMainBinding
import com.example.phone.databinding.ContactListVerticalBinding

class ContactsActivity : AppCompatActivity() {

    private lateinit var contacts: List<List<Contact>>
    private lateinit var adapter: ContactVerticalAdapter
    private lateinit var binding: ContactListVerticalBinding
    private lateinit var _binding: ContactListMainBinding
    private lateinit var contactVerticalView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ContactListMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        setSupportActionBar(_binding.toolbar)

        contactVerticalView = findViewById(R.id.recycler_view_horizontal)
        contactVerticalView.layoutManager = LinearLayoutManager(this)

        contacts = createContacts()
        adapter = ContactVerticalAdapter(contacts)
        contactVerticalView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun createContacts(): List<List<Contact>> {
        val contacts = ArrayList<List<Contact>>()
        val contactList1 = ArrayList<Contact>()
        contactList1.add(Contact("Nam", "0123456789"))
        contactList1.add(Contact("Tan", "0988997972"))
        contactList1.add(Contact("Kien", "0865482354"))

        val contactList2 = ArrayList<Contact>()
        contactList2.add(Contact("Quang", "0897997821"))
        contactList2.add(Contact("Duc", "0988997972"))
        contactList2.add(Contact("Minh", "0988997972"))

        val contactList3 = ArrayList<Contact>()
        contactList3.add(Contact("Eva", " 0458325466"))
        contactList3.add(Contact("Adam", "0846000452"))
        contactList3.add(Contact("Nam", "0123456789"))

        val contactList4 = ArrayList<Contact>()
        contactList4.add(Contact("Tan", "0988997972"))
        contactList4.add(Contact("Adam", "0846000452"))
        contactList4.add(Contact("Vinh", "0988997972"))

        val contactList5 = ArrayList<Contact>()
        contactList5.add(Contact("Tan", "0988997972"))
        contactList5.add(Contact("Adam", "0846000452"))
        contactList5.add(Contact("Vinh", "0988997972"))

        val contactList6 = ArrayList<Contact>()
        contactList6.add(Contact("Tan", "0988997972"))
        contactList6.add(Contact("Adam", "0846000452"))
        contactList6.add(Contact("Vinh", "0988997972"))

        val contactList7 = ArrayList<Contact>()
        contactList7.add(Contact("Tan", "0988997972"))
        contactList7.add(Contact("Adam", "0846000452"))
        contactList7.add(Contact("Vinh", "0988997972"))

        val contactList8 = ArrayList<Contact>()
        contactList8.add(Contact("Tan", "0988997972"))
        contactList8.add(Contact("Adam", "0846000452"))
        contactList8.add(Contact("Vinh", "0988997972"))

        val contactList9 = ArrayList<Contact>()
        contactList9.add(Contact("Tan", "0988997972"))
        contactList9.add(Contact("Adam", "0846000452"))
        contactList9.add(Contact("Vinh", "0988997972"))

        val contactList10 = mutableListOf<Contact>()
        contactList10.add(Contact("Tan", "0988997972"))
        contactList10.add(Contact("Adam", "0846000452"))
        contactList10.add(Contact("Vinh", "0988997972"))

        val contactList11 = ArrayList<Contact>()
        contactList11.add(Contact("Tan", "0988997972"))
        contactList11.add(Contact("Adam", "0846000452"))
        contactList11.add(Contact("Vinh", "0988997972"))

        contacts.add(contactList1)
        contacts.add(contactList2)
        contacts.add(contactList3)
        contacts.add(contactList4)
        contacts.add(contactList5)
        contacts.add(contactList6)
        contacts.add(contactList7)
        contacts.add(contactList8)
        contacts.add(contactList9)
        contacts.add(contactList10)
        contacts.add(contactList11)
        return contacts
    }
}