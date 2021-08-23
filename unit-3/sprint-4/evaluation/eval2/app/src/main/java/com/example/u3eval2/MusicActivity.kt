package com.example.u3eval2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_music.*

class MusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        val bundle: Bundle =intent.extras!!
        val img:Int=bundle.getInt("image")
        imgact.setImageResource(img)
        tvtrack1.setText(intent.getStringExtra("name"))
        tvartist1.setText(intent.getStringExtra("artist"))
        tvcollection1.setText(intent.getStringExtra("collection"))
    }
}