package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

     fun add(a: Double, b: Double):Double {
        return a + b
    }

    fun divide(a: Double, b: Double):Double {
        return a / b
    }

    fun multiply(a: Double, b: Double):Double {
        return a * b
    }

    fun substract(a: Double, b: Double):Double {
        return a - b
    }

    fun performCalculation(a: String, b: String, action: (Double, Double) -> Double): Double? {
        try {
            var firstArg = a.toDouble()
            var secondArg = b.toDouble()

            var result = action(firstArg, secondArg)
            return result
        } catch (e: java.lang.NumberFormatException) {
            Toast.makeText(applicationContext, resources.getText(R.string.value_error_msg), Toast.LENGTH_SHORT).show()
        } catch (e: java.lang.ArithmeticException) {
            Toast.makeText(applicationContext, resources.getText(R.string.zero_div_error_msg), Toast.LENGTH_SHORT).show()
        }
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var resultTextLabel = findViewById<TextView>(R.id.calcResultLabel)
        var firstArgText = findViewById<TextView>(R.id.firstArgInput)
        var secondArgText = findViewById<TextView>(R.id.secondArgInput)

        var multiplicationButton = findViewById<Button>(R.id.multiplicationButton)
        multiplicationButton.setOnClickListener{
            resultTextLabel.text = performCalculation(firstArgText.text.toString(), secondArgText.text.toString(), ::multiply)?.toString()
        }

        var divisionButton = findViewById<Button>(R.id.divisionButton)
        divisionButton.setOnClickListener{
            resultTextLabel.text = performCalculation(firstArgText.text.toString(), secondArgText.text.toString(), ::divide)?.toString()
        }
    }
}
