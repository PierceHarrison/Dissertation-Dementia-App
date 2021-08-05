package com.example.dissertation_dementia_app

//Imports for the MainActivity class
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Function to navigate to the MainMenu activity
    fun goToMainMenu(view: View?) {
        //Intent used to link between this class and the MainMenu class
        val intent = Intent(this, MainMenu::class.java)
        //Starts this intent to change to the Main Menu activity
        startActivity(intent)
    }
}