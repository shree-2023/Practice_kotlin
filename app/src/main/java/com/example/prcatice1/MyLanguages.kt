package com.example.prcatice1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MyLanguages : AppCompatActivity() {
    companion object{
        const val Key="com.example.practice1.MyLanguages.Key"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_languages)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val et1=findViewById<EditText>(R.id.et1)
        val et2=findViewById<EditText>(R.id.et2)
        val et3=findViewById<EditText>(R.id.et3)
        val et4=findViewById<EditText>(R.id.et4)

        val button= findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val llist=et1.text.toString()+"   "+ et2.text.toString()+ "   "+ et3.text.toString()+"  "+ et4.text.toString()

            intent= Intent(this,ListOfLangauges::class.java)
            intent.putExtra(Key,llist)
            startActivity(intent)
        }
    }
}