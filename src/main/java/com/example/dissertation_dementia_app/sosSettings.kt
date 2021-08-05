package com.example.dissertation_dementia_app

//Imports for the SosSettings class
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_face_reminder2.*
import kotlinx.android.synthetic.main.activity_sos_settings.*
import kotlinx.android.synthetic.main.face_add.*

class SosSettings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sos_settings)

//        val i = intent
//        val setENum = i.getStringExtra("ENumber")
//        eNumber.text = setENum

        //Sets value of submitE variable to be the id of the submitEButton in the SosSettings activity
        val submitE = findViewById<Button>(R.id.submitEBtn)

        //Sets an on click listener to submitEBtn
        submitE.setOnClickListener{
////            setName()
////            setRelation()
            //Runs the setE function
            setE()

//            val eNum = addENumber.getText().toString()
//            eNumber.text = eNum

        }
    }


    //Function used to set the emergency contact number
    private fun setE(){
        //Intent used to link this class to the MainMenu class
        val i = Intent(this@SosSettings, MainMenu::class.java)
        //Sets the key ENumber to the text in the addENumber editText in the SosSettings activity
        i.putExtra("ENumber", addENumber.text.toString())
        //Starts the intent i changing from SosSettings to the MainMenu activity
        startActivity(i)
//        val eNum = addENumber.getText().toString()
////      eNumber.text = eNum

    }
//    fun goToSosMenu(view: View?) {
//        val intent = Intent(this, SosSettings::class.java)
//        startActivity(intent)
    }
