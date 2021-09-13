package com.masai.contentproviders

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.contentprovider.R


class ContactsAdapter(context: Context?, contacts: ArrayList<Contact>?) :
        ArrayAdapter<Contact?>(context!!, 0, contacts!! as List<Contact?>) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get the data item
        val contact = getItem(position)
        // Check if an existing view is being reused, otherwise inflate the view
        var view = convertView
        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.adapter_item, parent, false)
        }
        // Populate the data into the template view using the data object
        val tvName = view!!.findViewById<View>(R.id.tvName) as TextView
        val tvEmail = view.findViewById<View>(R.id.tvEmail) as TextView
        val tvPhone = view.findViewById<View>(R.id.tvPhone) as TextView
        tvName.text = contact!!.name
        tvEmail.text = ""
        tvPhone.text = ""
        if (contact.emails.size > 0 && contact.emails[0] != null) {
            tvEmail.text = contact.emails[0].address
        }
        if (contact.numbers.size > 0 && contact.numbers[0] != null) {
            tvPhone.text = contact.numbers[0].number
        }
        return view
    }

}