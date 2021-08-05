//Code taken from GeeksforGeeks available from https://www.geeksforgeeks.org/image-slider-in-android-using-viewpager/
//Adapted by Pierce Harrison
package com.example.dissertation_dementia_app

//Imports for the MediaActivity class
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager


class MediaActivity : AppCompatActivity() {

    //Creates a new object of the layout manager ViewPager
    private var mViewPager: ViewPager? = null

    // Creates an array of images (Set to have two images image1 and image2 from the drawable folder
    private var images = intArrayOf(
        R.drawable.image1,
        R.drawable.image2
    )

    // Creates a variable to reference the ViewPagerAdapter
    private var mViewPagerAdapter: ViewPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)

        // Initializing the ViewPager
        mViewPager = findViewById<View>(R.id.viewPager) as ViewPager

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = ViewPagerAdapter(this@MediaActivity, images)

        // Adding the Adapter to the ViewPager
        mViewPager!!.adapter = mViewPagerAdapter
    }
}