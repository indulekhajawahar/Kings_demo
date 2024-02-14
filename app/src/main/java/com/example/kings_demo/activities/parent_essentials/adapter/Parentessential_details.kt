package com.example.kings_demo.activities.parent_essentials.adapter

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kings_demo.R
import com.example.kings_demo.activities.notifications.adapter.Details_adapter
import com.example.kings_demo.activities.notifications.model_details.Details_datalists
import com.example.kings_demo.activities.parent_essentials.model.Data_details
import com.example.kings_demo.activities.parent_essentials.model.Details_model
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class Parentessential_details : AppCompatActivity() {
    lateinit var context: Context

    lateinit var recycler_view: RecyclerView
    lateinit var title_list: ArrayList<String>
    lateinit var url_list: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.parentessential_details)
        context = this
        title_list= ArrayList()
        url_list= ArrayList()
         recycler_view= findViewById(R.id.parentessential_list)
        detailslist()

    }

    private fun detailslist() {
        try {
            Log.e("try","try")
            val obj = JSONObject(loadJSONFromAsset())
            val tst=obj.getString("message")
            Log.e("ts", tst.toString())
            val data = obj.getJSONObject("data")
            Log.e("ts", data.toString())

            val listsArray = data.getJSONArray("lists")
            Log.e("ar", listsArray.toString())
            for (i in 0..3 ) {
                val list = listsArray.getJSONObject(i)
                val id: Int = list.getInt("id")
                val title: String = list.getString("title")
                val url: String = list.getString("url")
                val model =Data_details(id, title, url)
                title_list.add(model.title)
                Log.e("title", title_list.toString())
                url_list.add(model.url)
                Log.e("at", url_list.toString())

                recycler_view.setLayoutManager(LinearLayoutManager(context))
                recycler_view.setAdapter(Parentessential_details_adapter(context, title_list, url_list))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }


    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("parentessentialdetails.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }
}