package com.imaec.sharedelementtransitiontest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ActivityOptionsCompat
import android.os.Build
import android.view.View
import androidx.core.util.Pair

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        imageMain.setOnClickListener {
        }
    }

    private fun init() {
        adapter = MainAdapter { item, view ->
            val intent = Intent(this, DetailActivity::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val p1 = Pair.create(view, view.transitionName)
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1)
                startActivity(intent, options.toBundle())
            } else {
                startActivity(intent)
            }
        }
        layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))

        for (i in 0 until 20) {
            adapter.addItem("$i 번째 ITEM")
        }
        adapter.notifyDataSetChanged()
    }
}
