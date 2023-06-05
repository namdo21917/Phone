package com.example.phone

import CalendarAdapter
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phone.databinding.CalendarBinding
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private lateinit var calendarRecyclerView: RecyclerView
    private lateinit var binding: CalendarBinding
    private lateinit var selectDate: LocalDate
    private lateinit var monthYearText: TextView
    private lateinit var adapter: CalendarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calendarRecyclerView = findViewById(R.id.calendarRecyclerView)
        monthYearText = findViewById(R.id.monthYearTV)
        selectDate = LocalDate.now()

        val previousButton: Button = findViewById(R.id.previous_button)
        val nextButton: Button = findViewById(R.id.next_button)

        previousButton.setOnClickListener {
            previousMonth()
        }

        nextButton.setOnClickListener {
            nextMonth()
        }
        setMonthView()
    }


    private fun setMonthView() {
        monthYearText.text = monthYearFromDate(selectDate)
        val daysInMonth: List<String> = daysInMonthArray(selectDate)

        calendarRecyclerView.layoutManager = GridLayoutManager(applicationContext, 7)
        calendarRecyclerView.adapter = CalendarAdapter(daysInMonth)

    }

    private fun previousMonth() {
        selectDate = selectDate.minusMonths(1)
        setMonthView()
    }

    private fun nextMonth() {
        selectDate = selectDate.plusMonths(1)
        setMonthView()
    }


    private fun daysInMonthArray(date: LocalDate): List<String> {
        val daysInMonthList = ArrayList<String>()
        val yearMonth: YearMonth = YearMonth.from(date)
        val daysInMonth = yearMonth.lengthOfMonth()

        val firstOfMonth: LocalDate = selectDate.withDayOfMonth(1)
        val dayOfWeek = firstOfMonth.dayOfWeek.value
        for (i in 1..42) {
            if (i <= dayOfWeek || i > daysInMonth + dayOfWeek) {
                daysInMonthList.add("")
            } else {
                daysInMonthList.add((i - dayOfWeek).toString())
            }
        }
        return daysInMonthList
    }

    private fun monthYearFromDate(date: LocalDate): String {
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter)
    }
}


//package com.example.phone
//
//import Contact
//import ContactVerticalAdapter
//import android.os.Bundle
//import android.view.Menu
//import android.view.MenuItem
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.phone.databinding.ContactListMainBinding
//import com.example.phone.databinding.ContactListVerticalBinding
//
//class MainActivity : AppCompatActivity() {
//    private lateinit var contacts: List<List<Contact>>
//    private lateinit var adapter: ContactVerticalAdapter
//    private lateinit var binding: ContactListVerticalBinding
//    private lateinit var _binding: ContactListMainBinding
//    private lateinit var contactVerticalView: RecyclerView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        _binding = ContactListMainBinding.inflate(layoutInflater)
//        setContentView(_binding.root)
//        setSupportActionBar(_binding.toolbar)
//
//        contactVerticalView = findViewById(R.id.recycler_view_horizontal)
//        contactVerticalView.layoutManager = LinearLayoutManager(this)
//
//        contacts = createContacts()
//        adapter = ContactVerticalAdapter(contacts)
//        contactVerticalView.adapter = adapter
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//
//
//    private fun createContacts(): List<List<Contact>> {
//        val contacts = ArrayList<List<Contact>>()
//        val contactList1 = ArrayList<Contact>()
//        contactList1.add(Contact("Nam", "0123456789"))
//        contactList1.add(Contact("Tan", "0988997972"))
//        contactList1.add(Contact("Kien", "0865482354"))
//
//        val contactList2 = ArrayList<Contact>()
//        contactList2.add(Contact("Quang", "0897997821"))
//        contactList2.add(Contact("Duc", "0988997972"))
//        contactList2.add(Contact("Minh", "0988997972"))
//
//        val contactList3 = ArrayList<Contact>()
//        contactList3.add(Contact("Eva", " 0458325466"))
//        contactList3.add(Contact("Adam", "0846000452"))
//        contactList3.add(Contact("Nam", "0123456789"))
//
//        val contactList4 = ArrayList<Contact>()
//        contactList4.add(Contact("Tan", "0988997972"))
//        contactList4.add(Contact("Adam", "0846000452"))
//        contactList4.add(Contact("Vinh", "0988997972"))
//
//        contacts.add(contactList1)
//        contacts.add(contactList2)
//        contacts.add(contactList3)
//        contacts.add(contactList4)
//        return contacts
//    }
//}
