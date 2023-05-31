import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phone.R

class ContactVerticalAdapter(
//    private val context: Context,
    private val contacts: List<List<Contact>>
) :
    RecyclerView.Adapter<ContactVerticalAdapter.ContactVerticalViewHolder>() {

    var onItemClick: ((List<Contact>) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactVerticalViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_list_vertical, parent, false)

        return ContactVerticalViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactVerticalViewHolder, position: Int) {
        val contacts = contacts[position]
        val contactViewHorizontal = holder.itemView.findViewById<RecyclerView>(R.id.recycler_view_horizontal)

        contactViewHorizontal.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        contactViewHorizontal.adapter = ContactHorizontalAdapter(contacts)
    }

    inner class ContactVerticalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(contacts: List<Contact>) {
            contacts
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(contacts[adapterPosition])
            }

        }
    }
}

