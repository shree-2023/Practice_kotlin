package com.example.prcatice1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewP1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view_p1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView = findViewById<ListView>(R.id.lvp1)
        val Editadditem = findViewById<EditText>(R.id.edt1)
        val additem = findViewById<ImageView>(R.id.add)

        val task = arrayListOf<String>()
        val adapterforlst = ArrayAdapter(this, android.R.layout.simple_list_item_1, task)
        listView.adapter = adapterforlst

        additem.setOnClickListener {
            val newtaskEditer = Editadditem.text.toString()
            if (newtaskEditer.isNotEmpty()) {
                task.add(newtaskEditer)
                adapterforlst.notifyDataSetChanged()
                Editadditem.text.clear()
                Editadditem.requestFocus()
            }
        }

        listView.setOnItemClickListener { parent, view, position, id ->
            showEditDeleteDialog(position, task, adapterforlst)
        }
    }

    private fun showEditDeleteDialog(position: Int, task: ArrayList<String>, adapter: ArrayAdapter<String>) {
        val dialogView = layoutInflater.inflate(R.layout.dialogue_edit, null)
        val editText = dialogView.findViewById<EditText>(R.id.edit_task)
        editText.setText(task[position])

        val dialog = AlertDialog.Builder(this)
            .setTitle("Edit or Delete Task")
            .setView(dialogView)
            .setPositiveButton("Save") { _, _ ->
                val editedTask = editText.text.toString()
                if (editedTask.isNotEmpty()) {
                    task[position] = editedTask
                    adapter.notifyDataSetChanged()
                }
            }
            .setNegativeButton("Delete") { _, _ ->
                task.removeAt(position)
                adapter.notifyDataSetChanged()
            }
            .setNeutralButton("Cancel", null)
            .create()

        dialog.show()
    }
}
