package com.example.prcatice1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
        val fav=findViewById<Button>(R.id.fav)
        val btn= findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            intent= Intent(this, Screen2:: class.java)
            startActivity(intent)
        }

       fav.setOnClickListener {
            intent= Intent(this, MyLanguages:: class.java)
            startActivity(intent)
        }
    }
}