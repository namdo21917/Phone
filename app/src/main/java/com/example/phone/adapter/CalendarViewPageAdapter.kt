package com.example.phone.adapter

import CalendarAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phone.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class CalendarViewPageAdapter(
    private var daysOfMonth: List<String>, private var selectDate: LocalDate
) :
    RecyclerView.Adapter<CalendarViewPageAdapter.CalendarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.calendar_page_view, parent, false)

        return CalendarViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return daysOfMonth.size
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.monthYearTV.text = monthYearFromDate(selectDate)
        val calendar = holder.itemView.findViewById<RecyclerView>(R.id.calendarRecyclerViewInPageViewer)
        setMonthView(calendar)

    }

    private fun setMonthView(recyclerView: RecyclerView) {
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context, 7)
        recyclerView.adapter = CalendarAdapter(daysOfMonth)

    }

    fun updateData(daysOfMonth: List<String>, selectDate: LocalDate) {
        this.daysOfMonth = daysOfMonth
        this.selectDate = selectDate
        notifyDataSetChanged()
    }

    private fun monthYearFromDate(date: LocalDate): String {
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter)
    }

    inner class CalendarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val monthYearTV: TextView = itemView.findViewById(R.id.monthYearTV)
    }
}

