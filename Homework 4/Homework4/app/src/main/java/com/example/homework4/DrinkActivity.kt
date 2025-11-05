package com.example.homework4

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.homework4.R

class DrinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_drink)

        val view = findViewById<android.view.View>(R.id.drink)
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupDrink)
        val btnNext = findViewById<Button>(R.id.btnNextDrink)

        val mainMeal = intent.getStringExtra("mainMeal")
        val sideDishes = intent.getStringArrayListExtra("sideDishes")

        btnNext.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, "請選擇飲料", Toast.LENGTH_SHORT).show()
            } else {
                val drink = findViewById<RadioButton>(selectedId).text.toString()
                val intent = Intent(this, ConfirmActivity::class.java)
                intent.putExtra("mainMeal", mainMeal)
                intent.putStringArrayListExtra("sideDishes", sideDishes)
                intent.putExtra("drink", drink)
                startActivity(intent)
            }
        }
    }
}