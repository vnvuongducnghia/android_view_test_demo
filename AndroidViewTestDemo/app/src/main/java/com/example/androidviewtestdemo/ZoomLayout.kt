package com.example.androidviewtestdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_zoom_layout.*

class ZoomLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoom_layout)
        btntest.setOnClickListener {
            myZoomLayout.setScrollEnabled(true)
        }
    }
}