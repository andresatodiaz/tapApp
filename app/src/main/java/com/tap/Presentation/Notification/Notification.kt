package com.tap.Presentation.Notification

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.tap.R
import kotlin.random.Random

class Notification(
    private val context: Context
) {
    private val notificationManager=context.getSystemService(NotificationManager::class.java)
    fun showBasicNotification(title:String,description:String){
        val notification= NotificationCompat.Builder(context,"notification")
            .setContentTitle(title)
            .setContentText(description)
            .setSmallIcon(R.drawable.taplogo)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }
}