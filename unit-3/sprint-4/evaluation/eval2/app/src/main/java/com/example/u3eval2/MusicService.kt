package com.example.u3eval2

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder

class MusicService : Service() {

    private lateinit var mediaPlayer:MediaPlayer

    fun MusicService(){

    }

    override fun onCreate() {
        super.onCreate()
        mediaPlayer= MediaPlayer.create(this,R.raw.dawood)
    }
    fun play(){
        if (!mediaPlayer.isPlaying){
            mediaPlayer.start()
        }
    }
    fun pause(){
        if(mediaPlayer.isPlaying){
            mediaPlayer.pause()
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return Servicebinder()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
    class Servicebinder:Binder(){
        fun MusicService(){
            return MusicService()


        }
    }
}