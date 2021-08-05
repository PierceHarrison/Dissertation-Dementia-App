package com.example.dissertation_dementia_app

//Imports for the MainMenu class
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_menu.*


class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        //Set i to be get the intent that started the activity
        val i = intent
        //Sets variable setSosNum to be the string value of the editText found in the SOS Settings activity
        val setSosNum = i.getStringExtra("ENumber")
        //sets display of invisible textView to be value of setSosNum
        sosNumber.text = setSosNum
    }

    //Function to navigate to the FaceRemind activity
    fun goToFaceRemind(view: View?) {
        //Intent used to link between this class and the FaceReminder class
        val intent = Intent(this, FaceReminder::class.java)
        //Starts this intent to change to the FaceReminder activity
        startActivity(intent)
    }

    //Function to navigate to the Schedule activity
    fun goToSchedule(view: View?) {
        //Intent used to link between this class and the Schedule class
        val intent = Intent(this, ScheduleActivity::class.java)
        //Starts this intent to change to the Schedule activity
        startActivity(intent)
    }

    //Function to navigate to the Clock activity
    fun goToClock(view: View?) {
        //Intent used to link between this class and the Clock class
        val intent = Intent(this, ClockActivity::class.java)
        //Starts this intent to change to the Clock activity
        startActivity(intent)
    }

//    fun goToSOS(view: View?) {
//        val intent = Intent(this, SOSFragment::class.java)
//        startActivity(intent)
//    }

    //Code taken from Vikalp Patel available at https://stackoverflow.com/questions/14082779/make-phone-call-android-and-get-number-from-edittext-box and adapted by Pierce Harrison
    //Function to navigate to the SOS activity
    fun goToSOS(view: View?){
        //Set variable string to the text of sosNumber textView with whitespace removed
        val string = sosNumber.text.toString().trim();
        //Set variable number to "tel:" plus the value of variable string
        val number = "tel:" + string
        //Create new intent that opens up the built in phone dialer
        val callIntent = Intent(Intent.ACTION_DIAL)
        //Input the value of varable number into the dialer
        callIntent.data = Uri.parse(number)
        //Start the call activity
        startActivity(callIntent)
    }

//    fun goToSOS(view: View?): Boolean {
//        try {
//            val intent = Intent(Intent.ACTION_CALL)
//            intent.setData(Uri.parse("tel:00000000"))
//            startActivity(intent)
//            return true
//        } catch (e: Exception) {
//            e.printStackTrace()
//            return false
//        }
//    }

    //Function to navigate to the Media activity
    fun goToMedia(view: View?) {
        //Intent used to link between this class and the Media class
        val intent = Intent(this, MediaActivity::class.java)
        //Starts this intent to change to the Media activity
        startActivity(intent)
    }

    //Function to navigate to the Audio activity
    fun goToAudio(view: View?) {
        //Intent used to link between this class and the Audio class
        val intent = Intent(this, AudioActivity::class.java)
        //Starts this intent to change to the Audio activity
        startActivity(intent)
    }

    //Function to navigate to the Settings activity
    fun goToSettings(view: View?) {
        //Intent used to link between this class and the Settings class
        val intent = Intent(this, SettingsMenu::class.java)
        //Starts this intent to change to the Settings activity
        startActivity(intent)
    }

}