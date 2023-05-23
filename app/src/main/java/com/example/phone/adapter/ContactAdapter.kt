import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.phone.R

class ContactAdapter(
//    private val context: Context,
    private val contacts: List<Contact>
) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    var onItemClick: ((Contact) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact, parent, false)

        return ContactViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)

//        holder.itemView.setOnClickListener {
//            val view = LayoutInflater.from(context).inflate(R.layout.contact_detail,true)
//        }
    }

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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

