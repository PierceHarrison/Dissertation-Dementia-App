package com.example.dissertation_dementia_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }



    fun goToFaceRemind(view: View?) {
        val intent = Intent(this, faceReminder::class.java)
        startActivity(intent)
    }

    fun goToSchedule(view: View?) {
        val intent = Intent(this, scheduleActivity::class.java)
        startActivity(intent)
    }

    fun goToClock(view: View?) {
        val intent = Intent(this, clockActivity::class.java)
        startActivity(intent)
    }

    fun goToSOS(view: View?) {
        val intent = Intent(this, SOSFragment::class.java)
        startActivity(intent)
    }

    fun goToMedia(view: View?) {
        val intent = Intent(this, MediaActivity::class.java)
        startActivity(intent)
    }


    fun goToAudio(view: View?) {
        val intent = Intent(this, AudioActivity::class.java)
        startActivity(intent)
    }

}