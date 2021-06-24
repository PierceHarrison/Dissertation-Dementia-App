package com.example.dissertation_dementia_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import kotlinx.android.synthetic.main.activity_face_reminder2.*
import kotlinx.android.synthetic.main.face_add.*

class FaceAdd : AppCompatActivity(), View.OnClickListener {
    lateinit var nameText: EditText
    lateinit var textView: TextView
    lateinit var  Button: Button
    lateinit var string: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.face_add)

        nameText = findViewById(R.id.addName)
        textView = findViewById(R.id.displayText)
        Button = findViewById(R.id.createBtn)

        Button.setOnClickListener {
            string = nameText.text.toString()
            textView.text = string
        }

    }

    override fun onClick(v: View?) {
        string = nameText.text.toString()
        textView.text = string
    }

}

//        createBtn.setOnClickListener {
//            saveName()
//            saveRelationship()
//            saveDOB()
//            saveEmail()
//            saveNumber()


//    fun saveName(){
//
//        var nameText = addName.text.toString()
//        addName.setText(nameText)
//        displayText.setText(nameText)
//    }
//
//    fun saveRelationship(){
//        var relationText = addRelation.text.toString()
//        addRelation.setText(relationText)
//        //do something with text
//    }
//
//    fun saveDOB(){
//        var dobText = addDOB.text.toString()
//        addDOB.setText(dobText)
//        //do something with text
//    }
//
//    fun saveEmail(){
//        var emailText = addEmail.text.toString()
//        addEmail.setText(emailText)
//        //do something with text
//    }
//
//    fun saveNumber(){
//        var numText = addNum.text.toString()
//        addNum.setText(numText)
//        //do something with text
//   }
//}
