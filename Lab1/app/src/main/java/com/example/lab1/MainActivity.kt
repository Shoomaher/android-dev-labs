package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * Add 2 numbers
     *
     * @param a 1 argument
     * @param b 2 argument
     * @return result of addition
     */
     fun add(a: Double, b: Double):Double {
        return a + b
    }

    /**
     * Divide 2 numbers
     *
     * @param a value which will be divided
     * @param b value which gonna divide
     * @return result of division - double of Infinity
     */
    fun divide(a: Double, b: Double):Double {
        return a / b
    }

    /**
     * Multiply 2 numbers
     *
     * @param a 1 argument
     * @param b 2 argument
     * @return result of multiplication
     */
    fun multiply(a: Double, b: Double):Double {
        return a * b
    }

    /**
     * Subsctract one number from another
     *
     * @param a value from which we substract
     * @param b value which we substract from another
     * @return result of subtraction
     */
    fun substract(a: Double, b: Double):Double {
        return a - b
    }

    /**
     * Perform action and get result of calculation
     *
     * @param a raw string from 1 argument
     * @param b raw string from 2 argument
     * @param action function that gonna be executed for 2 numbers
     * @return result of calculation or null if smth went wrong
     */
    fun performCalculation(a: String, b: String, action: (Double, Double) -> Double): Double? {
        try {
            val firstArg = a.toDouble()
            val secondArg = b.toDouble()

            val result = action(firstArg, secondArg)
            if (result == Double.POSITIVE_INFINITY) {
                Toast.makeText(applicationContext, resources.getText(R.string.zero_div_error_msg), Toast.LENGTH_SHORT).show()
                return null
            }

            return result
        } catch (e: java.lang.NumberFormatException) {
            Toast.makeText(
                applicationContext,
                resources.getText(R.string.value_error_msg),
                Toast.LENGTH_SHORT
            ).show()
        }
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultTextLabel = findViewById<TextView>(R.id.calcResultLabel)
        val firstArgText = findViewById<TextView>(R.id.firstArgInput)
        val secondArgText = findViewById<TextView>(R.id.secondArgInput)

        val multiplicationButton = findViewById<Button>(R.id.multiplicationButton)
        multiplicationButton.setOnClickListener{
            resultTextLabel.text = performCalculation(firstArgText.text.toString(), secondArgText.text.toString(), ::multiply)?.toString()
        }

        val divisionButton = findViewById<Button>(R.id.divisionButton)
        divisionButton.setOnClickListener{
            resultTextLabel.text = performCalculation(firstArgText.text.toString(), secondArgText.text.toString(), ::divide)?.toString()
        }
    }
}
