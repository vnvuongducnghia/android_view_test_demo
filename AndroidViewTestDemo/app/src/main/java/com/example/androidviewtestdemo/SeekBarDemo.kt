package com.example.androidviewtestdemo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_seek_bar_demo.*


class SeekBarDemo : AppCompatActivity() {

    private val TAG = "SeekBarDemo"
    private val DELTA_VALUE = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar_demo)


        seekBar.max = 100
        seekBar.progress = 15

        textView.text = "Progress: ${seekBar.progress} / ${seekBar.max}"

        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            var progress = 0

            // When Progress value changed.
            override fun onProgressChanged(seekBar: SeekBar, progressValue: Int, fromUser: Boolean) {
                progress = progressValue
                textView.text = "Progress: " + progressValue + "/" + seekBar.max
                Log.i(TAG, "Changing seekbar's progress")
                Toast.makeText(applicationContext, "Changing seekbar's progress", Toast.LENGTH_SHORT).show()
            }

            // Notification that the user has started a touch gesture.
            override fun onStartTrackingTouch(seekBar: SeekBar) {
                Log.i(TAG, "Started tracking seekbar")
                Toast.makeText(applicationContext, "Started tracking seekbar", Toast.LENGTH_SHORT).show()
            }

            // Notification that the user has finished a touch gesture
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                textView.text = "Progress: " + progress + "/" + seekBar.max
                Log.i(TAG, "Stopped tracking seekbar")
                Toast.makeText(applicationContext, "Stopped tracking seekbar", Toast.LENGTH_SHORT).show()
            }
        })

        button_decrease.setOnClickListener { decreateProgress() }

        button_increase.setOnClickListener { increateProgress() }
    }

    private fun decreateProgress() {
        val progress = seekBar.progress
        if (progress - DELTA_VALUE < 0) {
            seekBar.progress = 0
        }else{
            seekBar.progress = progress - DELTA_VALUE
        }
        textView.text = "Progress: ${seekBar.progress} / ${seekBar.max}"
    }

    private fun increateProgress() {
        val progress = this.seekBar.progress
        if (progress + DELTA_VALUE > seekBar.max) {
            this.seekBar.progress = seekBar.max
        } else {
            this.seekBar.progress = progress + DELTA_VALUE
        }
        textView.text = "Progress: ${seekBar.progress} / ${seekBar.max}"
    }
}