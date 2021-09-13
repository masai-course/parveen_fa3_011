package com.masai.contentproviders

import java.util.*


class Contact(var id: String, var name: String) {
    var emails: ArrayList<ContactEmail>
    var numbers: ArrayList<ContactPhone>
    override fun toString(): String {
        var result = name
        if (numbers.size > 0) {
            val number: ContactPhone = numbers[0]
            result += " (" + number.number.toString() + " - " + number.type.toString() + ")"
        }
        if (emails.size > 0) {
            val email: ContactEmail = emails[0]
            result += " [" + email.address.toString() + " - " + email.type.toString() + "]"
        }
        return result
    }

    fun addEmail(address: String?, type: String?) {
        emails.add(ContactEmail(address!!, type!!))
    }

    fun addNumber(number: String?, type: String?) {
        numbers.add(ContactPhone(number!!, type!!))
    }

    init {
        emails = ArrayList<ContactEmail>()
        numbers = ArrayList<ContactPhone>()
    }
}
