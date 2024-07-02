package com.example.prcatice1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val name=intent.getStringExtra(SignIn.Key2)
        val email=intent.getStringExtra(SignIn.Key1)
        val uid=intent.getStringExtra(SignIn.Key3)

        val welcome=findViewById<TextView>(R.id.welcome)
        val mail=findViewById<TextView>(R.id.email)
        val id=findViewById<TextView>(R.id.id)

        welcome.text="WELCOME $name"
        mail.text="Email $email"
        id.text="unique id $id"

    }
}