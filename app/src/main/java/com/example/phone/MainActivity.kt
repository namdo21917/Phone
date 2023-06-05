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

    //    private lateinit var recyclerView: RecyclerView
//    private lateinit var contacts: List<List<Contact>>
//    private lateinit var adapter: ContactVerticalAdapter
//    private lateinit var binding: ContactListVerticalBinding
//    private lateinit var _binding: ContactListMainBinding
//    private lateinit var contactVerticalView: RecyclerView
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