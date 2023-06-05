import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.phone.R


class CalendarViewPageAdapter(
    private val daysOfMonth: List<String>
) :
    RecyclerView.Adapter<CalendarViewPageAdapter.CalendarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.calendar_cell_page_view, parent, false)
        val layoutParams: ViewGroup.LayoutParams = itemView.layoutParams
        layoutParams.height = ((parent.height * 0.166666666).toInt())
        return CalendarViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return daysOfMonth.size
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.day.text = daysOfMonth[position]

    }

    inner class CalendarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val day: TextView = itemView.findViewById(R.id.cell_day_text)
    }
}

