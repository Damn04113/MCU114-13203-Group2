package com.example.homework4

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.homework4.R
import com.example.homework4.SideDishesActivity

class MainMealActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_meal)

        val view = findViewById<android.view.View>(R.id.main_meal)
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupMainMeal)
        val btnNext = findViewById<Button>(R.id.btnNextMainMeal)

        btnNext.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, "請選擇一項主餐", Toast.LENGTH_SHORT).show()
            } else {
                val selectedMeal = findViewById<RadioButton>(selectedId).text.toString()
                val intent = Intent(this, SideDishesActivity::class.java)
                intent.putExtra("mainMeal", selectedMeal)
                startActivity(intent)
            }
        }
    }
}
