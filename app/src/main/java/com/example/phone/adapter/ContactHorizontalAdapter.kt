import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.phone.R

class ContactHorizontalAdapter(
    private val contacts: List<Contact>
) :
    RecyclerView.Adapter<ContactHorizontalAdapter.ContactHorizontalViewHolder>() {

    var onItemClick: ((Contact) -> Unit)? = null
    var expandedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHorizontalViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_list_horizontal, parent, false)

        return ContactHorizontalViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactHorizontalViewHolder, position: Int) {
        val contact = contacts[position]
        val isExpanded = position === expandedPosition
//        holder.details.setVisibility(if (isExpanded) View.VISIBLE else View.GONE)
//        holder.itemView.isActivated = isExpanded
//        holder.itemView.setOnClickListener {
//            expandedPosition = if (isExpanded) -1 else position
//            notifyDataSetChanged()
//        }
    }

    inner class ContactHorizontalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val contactName: TextView = itemView.findViewById(R.id.contact_name)

        fun bind(contact: Contact) {
            contactName.text = contact.name
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(contacts[adapterPosition])
            }

        }
    }
}

