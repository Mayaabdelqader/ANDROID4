package com.example.ass44

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.app.Notification.EXTRA_NOTIFICATION_ID
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class SecondActivity : AppCompatActivity() {

    private var notificationId1 :Int = 123
    private var notificationId2 :Int = 234
    private var notificationId3 :Int = 345
    private val channelId = "App_Channel.testNotification"
    private val description = "Trying to test different types notification"
    private fun basicNotification() {
        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Princess Sumaya University for Technology")
            .setContentText("Welcome To PSUT!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(this)) {
            notify(notificationId1, builder.build())
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "test_notification"
            val descriptionText = description
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    lateinit var tEmail : TextView
    lateinit var tfName : TextView
    lateinit var tlName : TextView
    lateinit var tage : TextView
    lateinit var tgender : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        createNotificationChannel()
        var btnShowNotification:Button= findViewById(R.id.btnShowNotification)

        btnShowNotification.setOnClickListener {
            basicNotification()
        }

        tEmail = findViewById(R.id.temail)
        tfName = findViewById(R.id.tfname)
        tlName = findViewById(R.id.tlname)
        tage = findViewById(R.id.tage)
        tgender= findViewById(R.id.tgender)

        val bundle = intent.extras
        if (bundle != null){
            tEmail.text = "${bundle.getString("fname")}${bundle.getString("lname")}@std.psut.edu.jo\n\n"
            tfName.text = "First Name = ${bundle.getString("fname")}"
            tlName.text = "Last Name = ${bundle.getString("lname")}"
            tage.text = "Age = ${bundle.getString("age")}"
            tgender.text = "Gender =  ${bundle.getString("gender")}"


            val msg = "Welcome ${bundle.getString("fname")}"
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        }

    }
}
