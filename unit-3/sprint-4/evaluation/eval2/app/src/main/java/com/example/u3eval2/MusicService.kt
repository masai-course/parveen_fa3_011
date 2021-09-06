package com.example.u3eval2

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import java.util.*

class MusicService : Service() {

    private lateinit var mediaPlayer:MediaPlayer






    override fun onCreate() {
        super.onCreate()
        mediaPlayer= MediaPlayer.create(this,R.raw.dawood)
        showNotificationAndStartForeGround()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer.start()
        return super.onStartCommand(intent, flags, startId)
    }




    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.pause()
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    private fun showNotificationAndStartForeGround() {
        createChannel()
        var notificationBuilder: NotificationCompat.Builder? = null
        notificationBuilder = NotificationCompat.Builder(this, "CHANNEL_ID")
            .setContentTitle("Music is Playing")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
        var notification: Notification? = null
        notification = notificationBuilder.build()
        startForeground(1, notification)
    }


    /*
Create noticiation channel if OS version is greater than or eqaul to Oreo
*/
    fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "CHANNEL_ID",
                "CHANNEL_NAME",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = "Call Notifications"
            Objects.requireNonNull(
                this.getSystemService(
                    NotificationManager::class.java
                )
            ).createNotificationChannel(channel)
        }
    }

}