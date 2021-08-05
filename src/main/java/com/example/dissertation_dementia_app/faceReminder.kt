package com.example.dissertation_dementia_app

//Imports for FaceReminder class
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_face_reminder2.*

//Class declaration for FaceReminder
class FaceReminder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_face_reminder2)


//        val i = intent
//        val setName = i.getStringExtra("Name")
//        val setRelation = i.getStringExtra("Relation")
//        val setNum = i.getStringExtra("Num")
//        val setDOB = i.getStringExtra("DOB")
//        val setEmails = i.getStringExtra("Email")

        //Sets the value of sp to link to the sharedPreferences code in the FaceAdd class by using keyword "key"
        val sp = getSharedPreferences("key", 0)
        //Sets the value of setName to getting the value of Name from the sharedPreferences in FaceAdd class
        val setName = sp.getString("Name", "")
        //Sets the value of setRelation to getting the value of Relation (Relationship to user) from the sharedPreferences in FaceAdd class
        val setRelation = sp.getString("Relation", "")
        //Sets the value of setNum to getting the value of Num (Phone Number) from the sharedPreferences in FaceAdd class
        val setNum = sp.getString("Num", "")
        //Sets the value of setDOB to getting the value of DOB from the sharedPreferences in FaceAdd class
        val setDOB = sp.getString("DOB", "")
        //Sets the value of setEmails to getting the value of Email from the sharedPreferences in FaceAdd class
        val setEmails = sp.getString("Email", "")

        //Sets the value displayed in the name textView to be the value of setName (value of addName editText in FaceAdd)
        name.text = setName
        //Sets the value displayed in the relation textView to be the value of setName (value of addName editText in FaceAdd)
        relation.text = setRelation
        //Sets the value displayed in the phoneNumber textView to be the value of setName (value of addName editText in FaceAdd)
        phoneNumber.text = setNum
        //Sets the value displayed in the DOB textView to be the value of setName (value of addName editText in FaceAdd)
        dob.text = setDOB
        //Sets the value displayed in the email textView to be the value of setName (value of addName editText in FaceAdd)
        email.text = setEmails

//        setNameText()
//        setRelationText()
//

    }

//    fun setNameText(){
//        val nameI = intent
//        val nameText = nameI.getStringExtra("NameText")
//        // Now set this value to EditText
//        name.text = nameText
//    }
//
//    fun setRelationText(){
//        val relationI = intent
//        val relationText = relationI.getStringExtra("RelationText")
//        relation.text = relationText
//    }

    //Function used to navigate to the FaceAdd Activity
    fun goToFaceAdd(view: View?) {
        //Intent created to link this class and activity to the FaceAdd class and Activity
        val intent = Intent(this, FaceAdd::class.java)
        //Starts this intent to chnage to the FaceAdd activity
        startActivity(intent)
    }

    //Function used to navigate to the MainMenu Activity
    fun goToMainMenu(view: View?) {
        //Intent created to link this class and activity and the MainMenu class and activity
        val intent = Intent(this, MainMenu::class.java)
        //starts this Intent to change to the MainMenu activity
        startActivity(intent)
    }
}