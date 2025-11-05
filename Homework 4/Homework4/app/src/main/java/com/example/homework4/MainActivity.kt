package com.example.homework4

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import com.example.homework4.R
import com.example.homework4.SideDishesActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val view = findViewById<android.view.View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnMainMeal = findViewById<Button>(R.id.btnMainMeal)
        val btnSideDishes = findViewById<Button>(R.id.btnSideDishes)
        val btnDrink = findViewById<Button>(R.id.btnDrink)

        btnMainMeal.setOnClickListener {
            startActivity(Intent(this, MainMealActivity::class.java))
        }

        btnSideDishes.setOnClickListener {
            startActivity(Intent(this, SideDishesActivity::class.java))
        }

        btnDrink.setOnClickListener {
            startActivity(Intent(this, DrinkActivity::class.java))
        }
    }
}