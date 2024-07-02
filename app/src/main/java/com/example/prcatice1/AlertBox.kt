//package com.example.prcatice1
//
//import android.app.Dialog
//import android.content.DialogInterface
//import android.os.Bundle
//import android.widget.Button
//import android.widget.Toast
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AlertDialog
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import com.example.prcatice1.databinding.ActivityAlertBoxBinding
//
//class AlertBox : AppCompatActivity() {
//    lateinit var dialog: Dialog
//    lateinit var binding: ActivityAlertBoxBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding=ActivityAlertBoxBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//
//
//        binding.btn1.setOnClickListener {
//            val builder1 = AlertDialog.Builder(this)
//            builder1.setTitle("Are You Sure?")
//            builder1.setMessage("Do you really want to close the app...!")
//             builder1.setIcon(R.drawable.close)
//                builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
//            finish()
//        })
//        builder1.setNeutralButton("No", DialogInterface.OnClickListener { dialog, which ->
//            builder1.setMessage("Ok ")
//        })
//        builder1.show()
//        }
//
//      binding.btn2.setOnClickListener {
//
//          val option= arrayOf("Maggie", "Rasmallai", "Holige")
//          val builder2=AlertDialog.Builder(this)
//          builder2.setTitle("Select you Fav Food")
//          builder2.setSingleChoiceItems(option,0,DialogInterface.OnClickListener { dialog, which ->
//              Toast.makeText(this,"Your fav food is ${option[which]}",Toast.LENGTH_SHORT).show()
//          })
//          builder2.setPositiveButton("Submitter", DialogInterface.OnClickListener { dialog, which ->
//              builder2.setMessage("Ok ")
//          })
//          builder2.setNeutralButton("Decline", DialogInterface.OnClickListener { dialog, which ->
//
//          })
//          builder2.show()
//
//      }
//
//        binding.btn3.setOnClickListener {
//
//            val option= arrayOf("Maggie", "Rasmallai", "Holige")
//            val builder3=AlertDialog.Builder(this)
//            builder3.setTitle("Select you Fav Food")
//            builder3.setMultiChoiceItems(option,null,DialogInterface.OnMultiChoiceClickListener{dialog, which, isChecked ->
//                Toast.makeText(this,"Your fav food is ${option[which]}",Toast.LENGTH_SHORT).show()
//            })
//            builder3.setPositiveButton("Submitter", DialogInterface.OnClickListener { dialog, which ->
//                builder3.setMessage("Ok ")
//            })
//            builder3.setNeutralButton("Decline", DialogInterface.OnClickListener { dialog, which ->
//
//            })
//            builder3.show()
//
//        }
//
//        //custom dialogu box
//        dialog=Dialog(this)
//        dialog.setContentView(R.layout.custom_alert)
//        var btn4=findViewById<Button>(R.id.btn4)
//        var bad= findViewById<Button>(R.id.bad)
//        var good=findViewById<Button>(R.id.good)
//
//        good.setOnClickListener {
//            dialog.dismiss()
//        }
//        bad.setOnClickListener {
//            Toast.makeText(this,"Thank you for your feedback", Toast.LENGTH_SHORT).show()
//        }
//        btn4.setOnClickListener {
//            dialog.show()
//        }
//    }
//}

package com.example.prcatice1

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.prcatice1.databinding.ActivityAlertBoxBinding

class AlertBox : AppCompatActivity() {
    lateinit var dialog: Dialog
    lateinit var binding: ActivityAlertBoxBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlertBoxBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are You Sure?")
            builder1.setMessage("Do you really want to close the app...!")
            builder1.setIcon(R.drawable.close)
            builder1.setPositiveButton("Yes") { _, _ ->
                finish()
            }
            builder1.setNeutralButton("No") { dialog, _ ->
                builder1.setMessage("Ok ")
            }
            builder1.show()
        }

        binding.btn2.setOnClickListener {
            val options = arrayOf("Maggie", "Rasmallai", "Holige")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Select your Fav Food")
            builder2.setSingleChoiceItems(options, 0) { dialog, which ->
                Toast.makeText(this, "Your fav food is ${options[which]}", Toast.LENGTH_SHORT).show()
            }
            builder2.setPositiveButton("Submitter") { dialog, which ->
                builder2.setMessage("Ok ")
            }
            builder2.setNeutralButton("Decline", null)
            builder2.show()
        }

        binding.btn3.setOnClickListener {
            val options = arrayOf("Maggie", "Rasmallai", "Holige")
            val checkedItems = booleanArrayOf(false, false, false)
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Select your Fav Food")
            builder3.setMultiChoiceItems(options, checkedItems) { dialog, which, isChecked ->
                checkedItems[which] = isChecked
                Toast.makeText(this, "Your fav food is ${options[which]}", Toast.LENGTH_SHORT).show()
            }
            builder3.setPositiveButton("Submitter") { dialog, which ->
                builder3.setMessage("Ok ")
            }
            builder3.setNeutralButton("Decline", null)
            builder3.show()
        }

        // Custom dialog setup
        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_alert)

        // Initialize views from custom_alert.xml
//        var btn4 = dialog.findViewById<Button>(R.id.btn4)
        var bad = dialog.findViewById<Button>(R.id.bad)
        var good = dialog.findViewById<Button>(R.id.good)

        good.setOnClickListener {
            dialog.dismiss()
        }
        bad.setOnClickListener {
            Toast.makeText(this, "Thank you for your feedback", Toast.LENGTH_SHORT).show()
        }
        binding.btn4.setOnClickListener {
            dialog.show()
        }

    }
}
