package com.example.prcatice1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.prcatice1.databinding.ActivitySignInBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.security.Key


class SignIn : AppCompatActivity() {

    lateinit var databaseReference: DatabaseReference
companion object {
    var Key1 = "com.example.prcatice1.SignIn.email"
    var Key2 = "com.example.prcatice1.SignIn.name"
    var Key3 = "com.example.prcatice1.SignIn.uid"
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        var uid=findViewById<TextInputEditText>(R.id.unid)
        var signin=findViewById<Button>(R.id.signinbtn)
        var signup=findViewById<TextView>(R.id.textsignup)

        signup.setOnClickListener {
            intent= Intent(this,SignUp::class.java)
            startActivity(intent)
        }

        signin.setOnClickListener {
            var uid=uid.text.toString()
            if(uid.isNotEmpty()){
                readData(uid)
            }
            else{
                Toast.makeText(this,"Please enter valid user id",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(uid: String) {

databaseReference=FirebaseDatabase.getInstance().getReference("User")
        databaseReference.child(uid).get().addOnSuccessListener {

            if(it.exists()){
                var email=it.child("email").value
                val name=it.child("name").value
                val uid=it.child("uid").value

                intent=Intent(this,Home::class.java)
                intent.putExtra(Key1,email.toString())
                intent.putExtra(Key2,name.toString())
                intent.putExtra(Key3,uid.toString())
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"User Does not exist",Toast.LENGTH_SHORT).show()

            }
        }
            .addOnFailureListener {
                Toast.makeText(this,"failed ",Toast.LENGTH_SHORT).show()

            }
    }
}
