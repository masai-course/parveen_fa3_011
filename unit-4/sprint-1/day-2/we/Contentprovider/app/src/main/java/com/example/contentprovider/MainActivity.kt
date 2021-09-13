package com.masai.contentproviders

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.contentprovider.R
import java.security.acl.Permission


class MainActivity : AppCompatActivity() {
    private val CAMERA_PERMISSION_CODE = 100
    var listContacts: ArrayList<Contact>? = null
    var lvContacts: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listContacts = ContactFetcher(this).fetchAll()
        lvContacts = findViewById<View>(R.id.lvContacts) as ListView
        val adapterContacts = ContactsAdapter(this, listContacts)
        lvContacts?.setAdapter(adapterContacts)

        /**
         * Content provider
         *  - Sharing access to your application data(like sql tables) with other applications.
         *  A content provider manages access to a central repository of data.
         * - Main job - The Content provider object receives data requests from clients,
         * performs the requested action, and returns the results.
         *
         *
         *
         *
         * ContentResolver
         * - When you want to access data in a content provider,you use the ContentResolver object.
         * - The ContentResolver object communicates with the Content provider class.
         * - The ContentResolver methods provide the basic "CRUD" (create, retrieve, update, and delete) functions of persistent storage.
         *
         *
         *
         * CursorLoader
         * - A loader that queries the ContentResolver and returns a Cursor.
         * - Runs query in background and return results.
         *
         *
         * Constructing the query
         *  The set of columns that the query should return is called a projection
         *  query() insert() update()getType()
         *
         *
         */



        // Queries the user dictionary and returns results
        /*cursor = contentResolver.query(
                UserDictionary.Words.CONTENT_URI,   // The content URI of the words table
                projection,                        // The columns to return for each row
                selectionClause,                   // Selection criteria
                selectionArgs.toTypedArray(),      // Selection criteria
                sortOrder                          // The sort order for the returned rows
        )*/

        /**
         * Content URIs
         * - A content URI is a URI that identifies data in a provider.
         * Example URI: content://user_dictionary/words
         *
         */

        // Does a query against the table and returns a Cursor object
        /*mCursor = contentResolver.query(
                UserDictionary.Words.CONTENT_URI,  // The content URI of the words table
                projection,                       // The columns to return for each row
                selectionClause,                  // Either null, or the word the user entered
                selectionArgs,                    // Either empty, or the string the user entered
                sortOrder                         // The sort order for the returned rows
        )*/

        //SELECT _ID, word, locale FROM words WHERE word = <userinput> ORDER BY word ASC;


        /**
         * Cursor
         * The ContentResolver.query() client method always returns a Cursor containing
         * the columns specified by the query's projection for the rows that match the
         * query's selection criteria.
         */

        //Looping through cursor
        /*mCursor?.apply {
            // Determine the column index of the column named "word"
            val index: Int = getColumnIndex(UserDictionary.Words.WORD)

            while (moveToNext()) {
                // Gets the value from the column.
                newWord = getString(index)

            }*/

        checkPermission(Manifest.permission.READ_CONTACTS,
                CAMERA_PERMISSION_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "Camera Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "Camera Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(this@MainActivity, permission) == PackageManager.PERMISSION_DENIED) {
            // Requesting the permission
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission), requestCode)
            listContacts = ContactFetcher(this).fetchAll()
            lvContacts = findViewById<View>(R.id.lvContacts) as ListView
            val adapterContacts = ContactsAdapter(this, listContacts)
            lvContacts?.setAdapter(adapterContacts)
        } else {
            Toast.makeText(this@MainActivity, "Permission already granted", Toast.LENGTH_SHORT).show()
        }
    }

}