package com.example.kings_demo.activities.notifications.adapter

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

class Notification_adapter (var mcontext: Context,var title_list:ArrayList<String>,var alert_type_list:ArrayList<String>) :
    RecyclerView.Adapter<Notification_adapter.ViewHolder>() {

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
        viewHolder.title.setText(title_list[position])
        Log.e("postn",title_list[position])

        viewHolder.title.setOnClickListener() {
            Log.e("click","click")
             val i = Intent(viewHolder.itemView.context, Notification_details::class.java)
            i.putExtra("position", title_list[position])
            viewHolder.itemView.context.startActivity(i)
        }
    }
    override fun getItemCount(): Int {
        return title_list.size

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView

        init {
            title = itemView.findViewById(R.id.notification_list)

        }
    }
}