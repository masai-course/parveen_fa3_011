package com.example.u3eval2

import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_music.*

class MusicActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

      val intent=intent.extras!!
        tvtrack1.setText(intent.getString("name"))
        tvartist1.setText(intent.getString("artist"))
        tvcollection1.setText(intent.getString("collection"))

        val intent1= Intent(this,MusicService::class.java)
        btnPlay.setOnClickListener {
            startService(intent1)
        }
        btnPause.setOnClickListener {
            stopService(intent1)
        }
    }
}