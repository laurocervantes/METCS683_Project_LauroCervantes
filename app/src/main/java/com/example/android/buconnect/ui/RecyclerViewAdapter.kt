package com.example.android.buconnect.ui

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.roomwordssample.R

class RecyclerViewAdapter (val listOfData: ArrayList<String>, activity: HelloWorldHomeActivity): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    val travelActivity: HelloWorldHomeActivity = activity

    override fun onCreateViewHolder(p0: ViewGroup, position: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.cardview_main_profile, p0, false)
        return ViewHolder(v);
    }
    override fun getItemCount(): Int {
        return listOfData.size
    }

    override fun onBindViewHolder(p0: ViewHolder, position: Int) {
        p0.contactName?.text = listOfData[position]
        p0.contactName.setOnClickListener {
            travelActivity.travelToChat()
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactName = itemView.findViewById<TextView>(R.id.contactTextView)
    }
}
