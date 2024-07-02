package com.example.prcatice1

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewP2 : AppCompatActivity() {

    lateinit var UserArrayList:ArrayList<UserForLV>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view_p2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = arrayOf("Shree", "Prastuti", "Ankit", "Pradeep", "Aman")

        val lastMsg = arrayOf("Hey everyone", "I am fine", "Good", "Awesome", "cool")

        val lastMsgTime = arrayOf("6:25 AM", "7:30 PM", "5:00 PM", "6:25 AM", "7:30 PM")

        val phoneNumber = arrayOf("786453739", "986453739", "7366382829", "7383413440", "4159251517")

        val imgId = intArrayOf(R.drawable.image_shree, R.drawable.mypic, R.drawable.image_shree,
            R.drawable.mypic, R.drawable.image_shree)

        UserArrayList=ArrayList()
        for(index in name.indices){
            val user=UserForLV(name[index],lastMsg[index],lastMsgTime[index],phoneNumber[index],imgId[index])

        UserArrayList.add(user)
        }
        val listView=findViewById<ListView>(R.id.listView)

        listView.isClickable=true
        listView.adapter=MyAdapter(this,UserArrayList)

    }
}