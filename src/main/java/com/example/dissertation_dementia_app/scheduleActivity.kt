//Code taken from Tanu N Prabhu available at https://medium.com/@tanunprabhu95/to-do-list-application-using-kotlin-using-android-studio-546e74ac75aa
//Adapted by Pierce Harrison
package com.example.dissertation_dementia_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_schedule.*

class ScheduleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        // Initializing the array lists and the adapter
        val itemlist = arrayListOf<String>()
        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_multiple_choice
            , itemlist)

        //Creates an on click listener to the add button
        add.setOnClickListener {
            //Adds the value of addItemText editText to the itemList arrayList
            itemlist.add(addItemText.text.toString())
            itemList.adapter =  adapter
            //Notifies that data has been changed in the View
            adapter.notifyDataSetChanged()

            //Clears the value of the editText so that a new item can be entered
            addItemText.text.clear()
        }


        //Creates an on click listener to the clear button
        clear.setOnClickListener {
            //Removes all the items from itemlist arrayList
            itemlist.clear()
            //Notifies that the data has changed in the View
            adapter.notifyDataSetChanged()
        }

        // Toast message used to tell the user that they have selected a certain item in the list
        itemList.setOnItemClickListener { adapterView, view, i, l ->
            android.widget.Toast.makeText(this, "You Selected the item --> "+itemlist.get(i), android.widget.Toast.LENGTH_SHORT).show()
        }

        // Selecting and Deleting the items from the list when the delete button is pressed
        //Creates an on click listener to the delete button
        delete.setOnClickListener {
            //Sets the value of position to be the selected items in the list
            val position: SparseBooleanArray = itemList.checkedItemPositions
            //Sets the value of count to be the count of the itemList
            val count = itemList.count
            //Check the position of the item that has been selected and remove it from the list
            //then reduce size of list
            var item = count - 1
            while (item >= 0) {
                if (position.get(item))
                {
                    adapter.remove(itemlist.get(item))
                }
                item--
            }
            //Clears the position value
            position.clear()
            //Updates the View to show the changes that have been notified
            adapter.notifyDataSetChanged()
        }
    }
}