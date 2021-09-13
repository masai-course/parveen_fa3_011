package com.masai.contentproviders

import android.content.Context
import android.content.CursorLoader
import android.database.Cursor
import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import java.util.*


class ContactFetcher(private val context: Context) {

    fun fetchAll(): ArrayList<Contact> {

        val listContacts: ArrayList<Contact> = ArrayList<Contact>()

        return listContacts
    }
}