package com.example.prcatice1

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.prcatice1.databinding.ActivityViewbindingBinding

class Viewbinding : AppCompatActivity() {

    lateinit var binding:ActivityViewbindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate (savedInstanceState)
        binding=ActivityViewbindingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            if(binding.checkBox.isChecked)
            {
                Toast.makeText(this,"Thank You",Toast.LENGTH_LONG).show()
            }
            else{
                binding.checkBox.buttonTintList= ColorStateList.valueOf(Color.RED)
                Toast.makeText(this,"Please Complete All the field",Toast.LENGTH_LONG).show()

            }
        }

    }
}