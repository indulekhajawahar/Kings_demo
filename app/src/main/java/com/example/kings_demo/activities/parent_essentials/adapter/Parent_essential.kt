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
import com.example.kings_demo.activities.notifications.adapter.Notification_adapter
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class Parent_essential : AppCompatActivity() {
    lateinit var context: Context
    lateinit var banner: ImageView
    lateinit var description: TextView
    lateinit var parentsessential_list: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.parent_essential)
        context = this
        banner = findViewById(R.id.banner_parentessentials)
        description = findViewById(R.id.description_parentessentials)
        var recycler_view: RecyclerView = findViewById(R.id.parentsessential_list)
        banner()


        parentsessential_list = getResources().getStringArray(R.array.parentsessential_list)
        recycler_view.setLayoutManager(LinearLayoutManager(context))
        recycler_view.setAdapter( ParentsEssential_adapter(parentsessential_list))
    }

    private fun banner() {
        try {
            val obj = JSONObject(loadJSONFromAsset())
            val data = obj.getJSONObject("data")
            val banner_url=data.getString("banner_image")
            val description_data=data.getString("description")
            Log.e("bn", banner_url.toString())
            description.setText(description_data)
            if (banner_url.isNotEmpty()){
                context?.let {
                    Glide.with(it)
                        .load(banner_url)
                        .into(banner)
                }!!
            }
            else
            {
                Log.e("bnr","banner is empty")
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("parentessentials_banner.json")
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