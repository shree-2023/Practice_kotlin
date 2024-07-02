package com.example.prcatice1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class SignUp : AppCompatActivity() {

    lateinit var databse:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        var name= findViewById<TextInputEditText>(R.id.name)
        val email=findViewById<TextInputEditText>(R.id.email)
        val pwd=findViewById<TextInputEditText>(R.id.pwd)
        val uid=findViewById<TextInputEditText>(R.id.uid)
        val signup= findViewById<Button>(R.id.signup)
        val signin=findViewById<TextView>(R.id.textView)

        signup.setOnClickListener {
          val name= name.text.toString()
            val email= email.text.toString()
            val pwd= pwd.text.toString()
            val uid= uid.text.toString()

            val user=User(name,email,pwd,uid)
            databse=FirebaseDatabase.getInstance().getReference("User")
            databse.child(uid).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "SignUp Successfully",Toast.LENGTH_LONG).show()
                intent= Intent(this,SignIn::class.java)
                startActivity(intent)
            }
                .addOnFailureListener {
                    Toast.makeText(this, "Failed to SignUp" ,Toast.LENGTH_LONG).show()
                }
        }
        signin.setOnClickListener {
            intent=Intent(this,SignIn::class.java)
            startActivity(intent)
        }

    }
}