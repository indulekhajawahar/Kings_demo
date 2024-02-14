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
import com.example.kings_demo.activities.PdfReaderActivity
import com.example.kings_demo.activities.WebviewActivity

class Parentessential_details_adapter (var context: Context, var title_list:ArrayList<String>, var url_list:ArrayList<String>) :
    RecyclerView.Adapter<Parentessential_details_adapter.ViewHolder>() {
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
        var url_position=url_list[position]
Log.e("url",url_position)

        viewHolder.title.setOnClickListener(){
            val pdf:String=".pdf"
            if (url_position.contains(pdf)) {
                Log.e("dff", "gf")
                val i = Intent(viewHolder.itemView.context, PdfReaderActivity::class.java)
                i.putExtra("pdf_url", url_position)
                viewHolder.itemView.context.startActivity(i)
            }
            else{
                Log.e("dff", "op")
                val i = Intent(viewHolder.itemView.context, WebviewActivity::class.java)
                i.putExtra("web_url", url_position)
                viewHolder.itemView.context.startActivity(i)
            }
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