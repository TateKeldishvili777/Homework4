package com.example.homework4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var resultText: TextView
    private var operation: String = ""
    private var operand: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultText = findViewById(R.id.resultTextView)
    }

    public fun numberClick(view: View){
        if(view is Button){
            var result = resultText.text.toString()
            val number = view.text.toString()
            if(result == "0"){
                result = ""
            }
            val s = result + number
            resultText.text = s
        }
    }

    public fun operationClick(view: View){
        if (view is Button){
            operation = view.text.toString()
            operand = resultText.text.toString().toDouble()
            resultText.text = ""
        }
    }


    public fun equalsClick(view: View){
        val secondNumber = resultText.text.toString().toDouble()
        val k = when(operation){
            "+" -> operand + secondNumber
            "-" -> operand - secondNumber
            "*" -> operand * secondNumber
            "/" -> operand / secondNumber
            else -> {0.0}
        }
        resultText.text = k.toString()
    }

    public fun clean(view: View){
        if (view is Button){
            resultText.text = ""
        }
    }

}