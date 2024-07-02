package com.example.prcatice1

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest

class Screen2 : AppCompatActivity() {
    companion object {
        private const val REQUEST_CALL_PERMISSION = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen2)
        val calus = findViewById<Button>(R.id.callus)
        val android = findViewById<CardView>(R.id.android)
        val ios = findViewById<CardView>(R.id.ios)
        val bckchain = findViewById<CardView>(R.id.bckchain)
        val iot = findViewById<CardView>(R.id.iot)
        val web = findViewById<CardView>(R.id.web)
        val ml = findViewById<CardView>(R.id.ml)

        android.setOnClickListener {
            intent = Intent(this, Android::class.java)
            startActivity(intent)
        }

        ios.setOnClickListener {
            intent = Intent(this, IOS::class.java)
            startActivity(intent)
        }

        ml.setOnClickListener {
            intent = Intent(this, ML::class.java)
            startActivity(intent)
        }

        web.setOnClickListener {
            intent = Intent(this, Web::class.java)
            startActivity(intent)
        }

        bckchain.setOnClickListener {
            intent = Intent(this, BlockChain::class.java)
            startActivity(intent)
        }

        iot.setOnClickListener {
            intent = Intent(this, IOT::class.java)
            startActivity(intent)
        }

        calus.setOnClickListener {
            makePhoneCall()
        }
    }

    private fun makePhoneCall() {
        val number = "+91 9964300914"
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), REQUEST_CALL_PERMISSION)
        } else {
            val phoneIntent = Intent(Intent.ACTION_CALL)
            phoneIntent.data = Uri.parse("tel:$number")
            startActivity(phoneIntent)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                makePhoneCall()
            } else {
                // Permission denied, show a message to the user
            }
        }
    }
}
