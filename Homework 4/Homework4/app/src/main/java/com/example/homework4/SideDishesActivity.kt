package com.example.homework4

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.homework4.R

class SideDishesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_side_dishes)

        val view = findViewById<android.view.View>(R.id.side_dishes)
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val chkSoup = findViewById<CheckBox>(R.id.chkSoup)
        val chkSalad = findViewById<CheckBox>(R.id.chkSalad)
        val chkFries = findViewById<CheckBox>(R.id.chkFries)
        val btnNext = findViewById<Button>(R.id.btnNextSideDishes)

        val mainMeal = intent.getStringExtra("mainMeal")

        btnNext.setOnClickListener {
            val sides = mutableListOf<String>()
            if (chkSoup.isChecked) sides.add("湯品")
            if (chkSalad.isChecked) sides.add("沙拉")
            if (chkFries.isChecked) sides.add("薯條")

            if (sides.isEmpty()) {
                Toast.makeText(this, "請至少選擇一項副餐", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, DrinkActivity::class.java)
                intent.putExtra("mainMeal", mainMeal)
                intent.putStringArrayListExtra("sideDishes", ArrayList(sides))
                startActivity(intent)
            }
        }
    }
}
