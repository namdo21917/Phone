package com.example.phone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.phone.databinding.ContactDetailBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ContactDetailFragment : Fragment() {

    private var _binding: ContactDetailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ContactDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.to_contacts_recycler_view)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}