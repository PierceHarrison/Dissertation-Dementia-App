package com.example.dissertation_dementia_app

//Imports for the SettingsMenu class
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SettingsMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_menu)
    }

    //Function to navigate to the SOS Settings activity
    fun goToSosMenu(view: View?) {
        //Intent used to link between this class and the SosSettings class
        val intent = Intent(this, SosSettings::class.java)
        //Starts this intent to change to the SOS Settings activity
        startActivity(intent)
    }
}