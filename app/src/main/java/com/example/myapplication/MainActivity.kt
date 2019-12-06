package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    calButton.setOnClickListener() {
        try {
            val weight = weightValue.text.toString().toDouble()
            val weightValue: Double = weight.toDouble()

            val height = heightValue.text.toString().toDouble()
            val heightValue: Double = height.toDouble()

            val bMI = weightValue / Math.pow(heightValue, 2.0)
            var state: String = ""

            //display image
            if (bMI == 0.0) {
                imgBMI.setImageResource(R.drawable.empty)
                state = "Empty"
            } else if (bMI < 18.5) {
                imgBMI.setImageResource(R.drawable.under)
                state = "Under"
            } else if (bMI >= 18.5 && bMI <= 24.9) {
                imgBMI.setImageResource(R.drawable.normal)
                state = "Normal"
            } else if (bMI > 24.9) {
                imgBMI.setImageResource(R.drawable.over)
                state = "Over"
            }
            bmiValue.text = "%.2f (%s)".format(bMI, state)

        } catch (ex: Exception) {
            val toast: Toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG)

            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
        resetButton.setOnClickListener(){
            weightValue.text.clear()
            heightValue.text.clear()
            bmiValue.text=null
            imgBMI.setImageResource(R.drawable.empty)
        }

    }

    }
}
