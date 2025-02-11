package com.example.kotlinapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get UI elements
        val edtAmount = findViewById<TextInputEditText>(R.id.edtAmount)
        val edtPeople = findViewById<TextInputEditText>(R.id.edtPeople)
        val edtTip = findViewById<TextInputEditText>(R.id.edtTip)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnCalculate.setOnClickListener {
            val amountStr = edtAmount.text.toString()
            val peopleStr = edtPeople.text.toString()
            val tipStr = edtTip.text.toString()

            // Validate input
            if (amountStr.isEmpty() || peopleStr.isEmpty() || tipStr.isEmpty()) {
                txtResult.text = "Please enter all values!"
                return@setOnClickListener
            }

            try {
                val totalAmount = amountStr.toFloat()
                val numberOfPeople = peopleStr.toInt()
                val tipAmount = tipStr.toFloat()

                if (numberOfPeople == 0) {
                    txtResult.text = "Number of people cannot be zero!"
                    return@setOnClickListener
                }

                val individualShare = (totalAmount + tipAmount) / numberOfPeople
                txtResult.text = "Individual Amount: ₹%.2f".format(individualShare)

            } catch (e: Exception) {
                txtResult.text = "Invalid input! Please enter numbers only."
            }
        }

        btnReset.setOnClickListener {
            edtAmount.text?.clear()
            edtPeople.text?.clear()
            edtTip.text?.clear()
            txtResult.text = "Individual Amount: "
        }
    }
}
