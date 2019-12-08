package com.imaec.sharedelementtransitiontest

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var fragmentAdapter: FragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            supportPostponeEnterTransition()
        }
        setContentView(R.layout.activity_detail)

        init()
    }

    private fun init() {
        fragmentAdapter = FragmentAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter

        for (i in 0 until 6) {
            val fragment = ImageFragment()
            fragmentAdapter.addItem(fragment)
        }
        fragmentAdapter.notifyDataSetChanged()
    }
}