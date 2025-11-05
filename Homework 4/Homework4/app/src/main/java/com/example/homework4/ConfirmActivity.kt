package com.example.homework4

import android.content.DialogInterface
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.homework4.R

class ConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirm)

        val view = findViewById<android.view.View>(R.id.confirm)
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 接收前面頁面傳來的資料
        val mainMeal = intent.getStringExtra("mainMeal")
        val sideDishes = intent.getStringArrayListExtra("sideDishes")
        val drink = intent.getStringExtra("drink")

        // 顯示內容
        val txtSummary = findViewById<TextView>(R.id.txtSummary)
        val btnConfirm = findViewById<Button>(R.id.btnConfirm)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val summary = buildString {
            append("主餐：$mainMeal\n")
            append("配餐：${sideDishes?.joinToString("、")}\n")
            append("飲料：$drink")
        }
        txtSummary.text = summary

        // 按下確認按鈕
        btnConfirm.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
                .setTitle("確認訂單")
                .setMessage("確定要送出這份訂單嗎？")
                .setPositiveButton("確定") { _: DialogInterface, _: Int ->
                    Toast.makeText(this, "訂單已送出！", Toast.LENGTH_SHORT).show()
                    finishAffinity() // 結束所有Activity
                }
                .setNegativeButton("取消", null)
                .create()
            dialog.show()
        }

        // 返回修改
        btnBack.setOnClickListener {
            finish() // 回到上一頁
        }
    }
}