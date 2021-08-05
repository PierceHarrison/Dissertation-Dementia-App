//Code taken from https://stackoverflow.com/questions/27589701/showing-morning-afternoon-evening-night-message-based-on-time-in-java and adapted by Pierce Harrison
package com.example.dissertation_dementia_app

//Imports for ClockActivity class
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class ClockActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)
//        setSupportActionBar(findViewById(R.id.toolbar))
        //gets a calender using the default time zone and sets it to be variable c
            val c = Calendar.getInstance()
            //Uses the calender to get the hour of the day and sets it to be variable timeOfDay
            val timeOfDay = c[Calendar.HOUR_OF_DAY]

            //If Else statements used to check during each part of the day
            //If the time of day is between sets of hours a toast message will be displayed for the user to tell them what time of day it is
            //ie. Morning, Afternoon, Night
            if (timeOfDay in 0..11) {
                Toast.makeText(this, "Good Morning", Toast.LENGTH_SHORT).show()
            } else if (timeOfDay in 12..16) {
                Toast.makeText(this, "Good Afternoon", Toast.LENGTH_SHORT).show()
            } else if (timeOfDay in 17..23) {
                Toast.makeText(this, "Good Night", Toast.LENGTH_SHORT).show()
            }
        }

    }
