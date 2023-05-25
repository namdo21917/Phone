package com.example.phone

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.phone.databinding.ContactDetailBinding


class ContactDetailActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ContactDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val contactName = intent.extras?.getString("CONTACT_NAME")
        val contactTel = intent.extras?.getString("CONTACT_TEL")
        val contactNameText = findViewById<TextView>(R.id.contact_name)
        contactNameText.text = contactName
        val contactTelText = findViewById<TextView>(R.id.contact_tel)
        contactTelText.text = contactTel

    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
////        menuInflater.inflate(R.menu.menu_main, menu)
////        return true
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.e("LOI", "loi roi")
        return when (item.itemId) {
            R.id.contact_list -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.to_contact_list)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}