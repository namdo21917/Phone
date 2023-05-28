package com.example.phone

import Contact
import ContactAdapter
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phone.databinding.ActivityMainBinding
import com.example.phone.databinding.ContactListBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var contacts: List<Contact>
    private lateinit var adapter: ContactAdapter
    private lateinit var binding: ContactListBinding
    private lateinit var _binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        _binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(_binding.root)
//        setSupportActionBar(_binding.toolbar)

        binding = ContactListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        recyclerView = findViewById(R.id.contact_list)
        recyclerView.layoutManager = LinearLayoutManager(this)

        contacts = createContacts()
        adapter = ContactAdapter(contacts)
        recyclerView.adapter = adapter
        adapter.onItemClick = { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("CONTACT_NAME", contact.name)
            intent.putExtra("CONTACT_TEL", contact.tel)
            startActivity(intent)

        }

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


    private fun createContacts(): List<Contact> {
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