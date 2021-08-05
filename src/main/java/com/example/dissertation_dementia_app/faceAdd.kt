package com.example.dissertation_dementia_app

//Imports for FaceAdd class
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.face_add.*


class FaceAdd : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.face_add)

//        var et_name = findViewById<EditText>(R.id.addName)
        //Sets btnSubmit to be the id of the submitBtn button in the FaceAdd activity
        val btnSubmit = findViewById<Button>(R.id.submitBtn)

        //Creates an on click listener for the submit button
        btnSubmit.setOnClickListener{
//            setName()
//            setRelation()
//            setText()

            //Sets the value of sp to be the shared preferences with a "key"
            val sp = getSharedPreferences("key", 0)
            //Sets the value of spedit to be a new editor for the shared preferences sp
            val spedit = sp.edit()
            //Sets the shared preference with key Name to be the text of the addName editText
            spedit.putString("Name", addName.text.toString())
            //Sets the shared preference with key Relation to be the text of the addRelation editText
            spedit.putString("Relation", addRelation.text.toString())
            //Sets the shared preference with key Num to be the text of the addNum editText
            spedit.putString("Num", addNum.text.toString())
            //Sets the shared preference with key DOB to be the text of the addDOB editText
            spedit.putString("DOB", addDOB.text.toString())
            //Sets the shared preference with key Email to be the text of the addEmail editText
            spedit.putString("Email", addEmail.text.toString())
            //commits the preferences changes
            spedit.apply()

        }


    }


//    fun setName(){
//        val et_name = findViewById<EditText>(R.id.addName)
//
//        val setName = et_name.text
//
//        val setNText = findViewById<TextView>(R.id.name)
//
//        setNText.text = setName
//
//        val nIntent = Intent(this@FaceAdd, FaceReminder::class.java)
//        nIntent.putExtra("NameText", addName.getText().toString())
//        startActivity(nIntent)
//    }
//
//    fun setRelation(){
//        val rIntent = Intent(this@FaceAdd, FaceReminder::class.java)
//        rIntent.putExtra("RelationText", addName.getText().toString())
//        startActivity(rIntent)
//
//        val et_relation = findViewById<EditText>(R.id.addRelation)
//
//        val setRelation = et_relation.text
//
//        val setRText = findViewById<TextView>(R.id.relation)
//
//        setRText.text = setRelation
//    }

//    fun setText(){
//        val i = Intent(this@FaceAdd, FaceReminder::class.java)
//        i.putExtra("Name", addName.getText().toString())
//        i.putExtra("Relation", addRelation.getText().toString())
//        i.putExtra("Num", addNum.getText().toString())
//        i.putExtra("DOB", addDOB.getText().toString())
//        i.putExtra("Email", addEmail.getText().toString())
//        startActivity(i)
//    }


    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    //Function used to navigate to the FaceReminder activity
    fun goToFaceRemind(view: View?) {
        //Intent used to link this class and the FaceReminder class
        val intent = Intent(this, FaceReminder::class.java)
        //Starts the intent to change the activity from this to the FaceReminder
        startActivity(intent)
    }

}


