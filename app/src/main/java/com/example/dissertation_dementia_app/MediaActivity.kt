package com.example.dissertation_dementia_app

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager


class MediaActivity : AppCompatActivity() {
    // creating object of ViewPager
    private var mViewPager: ViewPager? = null

    // images array
    private var images = intArrayOf(
        R.drawable.image1,
        R.drawable.image2
    )

    // Creating Object of ViewPagerAdapter
    private var mViewPagerAdapter: ViewPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)

        // Initializing the ViewPager Object
        mViewPager = findViewById<View>(R.id.viewPager) as ViewPager

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = ViewPagerAdapter(this@MediaActivity, images)

        // Adding the Adapter to the ViewPager
        mViewPager!!.adapter = mViewPagerAdapter
    }
}