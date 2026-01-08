package com.teedev.electriccalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class showResult : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_result)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intent = intent
        val unitStr = intent.getStringExtra("UnitPower")
        val typeStr = intent.getStringExtra("typeChecked")

        var unit = 0.0
        if (unitStr != null) {
            unit = unitStr.toDouble()
        }

        val showUnit = findViewById<TextView>(R.id.showUnitTxt)
        val showType = findViewById<TextView>(R.id.showtype)
        val showFee = findViewById<TextView>(R.id.showFee)
        val btnHome = findViewById<Button>(R.id.backHome)

        var sumMoney = 0.0
        var service = 0.0

        if (typeStr == "1") {
            service = 8.19
            var u = unit

            if (u > 0) {
                var cal = 0.0
                if (u > 15) { cal = 15.0 } else { cal = u }
                sumMoney += (cal * 2.3488)
                u -= cal
            }

            if (u > 0) {
                var cal = 0.0
                if (u > 10) { cal = 10.0 } else { cal = u }
                sumMoney += (cal * 2.9882)
                u -= cal
            }

            if (u > 0) {
                var cal = 0.0
                if (u > 10) { cal = 10.0 } else { cal = u }
                sumMoney += (cal * 3.2405)
                u -= cal
            }

            if (u > 0) {
                var cal = 0.0
                if (u > 65) { cal = 65.0 } else { cal = u }
                sumMoney += (cal * 3.6237)
                u -= cal
            }

            if (u > 0) {
                var cal = 0.0
                if (u > 50) { cal = 50.0 } else { cal = u }
                sumMoney += (cal * 3.7171)
                u -= cal
            }

            if (u > 0) {
                var cal = 0.0
                if (u > 250) { cal = 250.0 } else { cal = u }
                sumMoney += (cal * 4.2218)
                u -= cal
            }

            if (u > 0) {
                sumMoney += (u * 4.4217)
            }

        } else {
            service = 38.22
            var u = unit

            if (u > 0) {
                var cal = 0.0
                if (u > 150) { cal = 150.0 } else { cal = u }
                sumMoney += (cal * 3.2484)
                u -= cal
            }

            if (u > 0) {
                var cal = 0.0
                if (u > 250) { cal = 250.0 } else { cal = u }
                sumMoney += (cal * 4.2218)
                u -= cal
            }

            if (u > 0) {
                sumMoney += (u * 4.4217)
            }
        }

        val ft = unit * -0.048
        var total = sumMoney + service + ft
        val vat = total * 0.07
        total += vat

        val bath = total.toInt()
        val satang = total - bath

        var totalSatang = 0.0
        if (satang < 0.125) {
            totalSatang = 0.0
        } else if (satang < 0.25) {
            totalSatang = 0.25
        } else if (satang < 0.375) {
            totalSatang = 0.25
        } else if (satang < 0.50) {
            totalSatang = 0.50
        } else if (satang < 0.625) {
            totalSatang = 0.50
        } else if (satang < 0.75) {
            totalSatang = 0.75
        } else if (satang < 0.875) {
            totalSatang = 0.75
        } else {
            totalSatang = 1.0
        }

        val finalResult = bath + totalSatang

        showUnit.text = "Unit: " + unit.toInt()
        showType.text = "Type: $typeStr"
        showFee.text = "Fee: " + String.format("%.2f", finalResult) + " Bath"

        btnHome.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}