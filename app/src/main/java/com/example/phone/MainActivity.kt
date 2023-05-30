package com.example.phone

import Contact
import ContactVerticalAdapter
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phone.databinding.ContactListVerticalBinding

class MainActivity : AppCompatActivity() {

//    private lateinit var recyclerView: RecyclerView
    private lateinit var contacts: List<List<Contact>>
    private lateinit var adapter: ContactVerticalAdapter
    private lateinit var binding: ContactListVerticalBinding
    private lateinit var contactVerticalView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        _binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(_binding.root)
//        setSupportActionBar(_binding.toolbar)

//        binding = ContactListVerticalBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        setSupportActionBar(binding.toolbar)
//
//        recyclerView = findViewById(R.id.contact_list_vertical)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        contacts = createContacts()
//        adapter = ContactVerticalAdapter(contacts)
//        recyclerView.adapter = adapter
//        adapter.onItemClick = { contact ->
//            val intent = Intent(this, ContactDetailActivity::class.java)
//            intent.putExtra("CONTACT_NAME", contact.name)
//            intent.putExtra("CONTACT_TEL", )
//            startActivity(intent)
//
//        }
//        horizontalAdapter = ContactAdapter(contacts)
//        horizontalRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding = ContactListVerticalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contactVerticalView = findViewById(R.id.recycler_view_vertical)
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

        contacts.add(contactList1)
        contacts.add(contactList2)
        contacts.add(contactList3)
        contacts.add(contactList4)
        return contacts
    }
}