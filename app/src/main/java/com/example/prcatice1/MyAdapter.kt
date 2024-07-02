package com.example.prcatice1

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(val context:Activity, val arrayList: ArrayList<UserForLV>) :
    ArrayAdapter<UserForLV>(context,R.layout.eachitem_listviewp2,arrayList) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater=LayoutInflater.from(context)
        val view=inflater.inflate(R.layout.eachitem_listviewp2,null)
        val image=view.findViewById<CircleImageView>(R.id.profile_image)
        val name=view.findViewById<TextView>(R.id.textname)
        val lastMsg=view.findViewById<TextView>(R.id.textMsg)
        val lastMsgTime=view.findViewById<TextView>(R.id.textTime)

        name.text=arrayList[position].name
        lastMsg.text=arrayList[position].lastMsg
        lastMsgTime.text=arrayList[position].lastMsgTime
        image.setImageResource(arrayList[position].imgId)


        return view
    }
}
