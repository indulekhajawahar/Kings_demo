package com.example.kings_demo.activities.parent_essentials.adapter

import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.kings_demo.R
import com.example.kings_demo.activities.notifications.adapter.Notification_adapter
import com.example.kings_demo.activities.notifications.adapter.Notification_details

class ParentsEssential_adapter ( var parentsessential_list:Array<String>) :
    RecyclerView.Adapter<ParentsEssential_adapter.ViewHolder>() {
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.notification_adapter, viewGroup, false)
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.title.setText(parentsessential_list[position])
        Log.e("postn",parentsessential_list[position])
        viewHolder.title.setOnClickListener(){
            val i = Intent(viewHolder.itemView.context, Parentessential_details::class.java)
            viewHolder.itemView.context.startActivity(i)
        }
    }
    override fun getItemCount(): Int {
        return parentsessential_list.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView

        init {
            title = itemView.findViewById(R.id.notification_list)

        }
    }
}