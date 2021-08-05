//Code taken from GeeksforGeeks available from https://www.geeksforgeeks.org/image-slider-in-android-using-viewpager/
//Adapted by Pierce Harrison
package com.example.dissertation_dementia_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import java.util.*


class ViewPagerAdapter(
    //Sets variable context to Context Object
    var context: Context,
    //Sets the variable images to an integer array
    private var images: IntArray
) :
    PagerAdapter() {
    // Layout Inflater
    private var mLayoutInflater: LayoutInflater
    override fun getCount(): Int {
        // return the number of images
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // inflating the item.xml
        val itemView = mLayoutInflater.inflate(R.layout.item, container, false)

        // referencing the image view from the item.xml file
        val imageView = itemView.findViewById<View>(R.id.imageViewMain) as ImageView

        // setting the image in the imageView
        imageView.setImageResource(images[position])

        // Adding the View
        Objects.requireNonNull(container).addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }

    // Viewpager Constructor
    init {
        images
        mLayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
}