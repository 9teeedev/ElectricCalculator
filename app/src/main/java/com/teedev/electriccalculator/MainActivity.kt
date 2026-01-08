package com.teedev.electriccalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val inputPower = findViewById<EditText>(R.id.inputPower)
        val type1 = findViewById<RadioButton>(R.id.radioT1)
        val type2 = findViewById<RadioButton>(R.id.radioT2)
        val btnCal = findViewById<Button>(R.id.btnCal)

        btnCal.setOnClickListener{
            var typeChecked = "1"
            if (type1.isChecked){
                typeChecked = "1"
            }else if(type2.isChecked){
                typeChecked = "2"
            }

            val i = Intent(this@MainActivity, showResult::class.java)
            i.putExtra("typeChecked", typeChecked)
            i.putExtra("UnitPower", inputPower.text.toString())
            startActivity(i)
        }
    }
}