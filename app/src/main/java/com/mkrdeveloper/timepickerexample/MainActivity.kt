package com.mkrdeveloper.timepickerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.TimePicker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tp = findViewById<TimePicker>(R.id.timePicker)
        val txt = findViewById<TextView>(R.id.textView)

        tp.setOnTimeChangedListener { view, hourOfDay, minute ->

            var hour = hourOfDay
            var format = ""

            if (hour >= 12){
                format = "PM"
                if (hour != 12)
                    hour -= 12
            }else{
                format = "AM"
            }

            txt.text = addZero(hour) + " : " + addZero( minute) + " $format"
        }
    }

    private fun addZero (num: Int): String{
        return if (num <= 9) "0$num" else num.toString()
    }
}