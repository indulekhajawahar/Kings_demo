package com.example.kings_demo.activities.notifications.adapter

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kings_demo.R
import com.example.kings_demo.activities.notifications.model.Notification_datalists
import com.example.kings_demo.activities.notifications.model.Notification_model
import com.example.kings_demo.activities.notifications.model_details.Details_datalists
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class Notification_details: AppCompatActivity() {

    lateinit var context:Context
    lateinit var lists: ArrayList<String>
    lateinit var content_list: ArrayList<String>
    lateinit var type_list: ArrayList<String>
    lateinit var recycler_view: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notificationdetails)
        context = this
        lists = ArrayList()
        content_list = ArrayList()
        type_list = ArrayList()
        recycler_view=findViewById(R.id.details_recycler)
        json()
    }

private fun json(){
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
            val id:Int=list.getInt("id")
            val title:String=list.getString("title")
            val type:String=list.optString("type")
            val content:String=list.getString("content")
            val read_unread_status:Int=list.getInt("read_unread_status")
            val model= Details_datalists(id,title,type,content,read_unread_status)

            content_list.add(model.content)
            Log.e("title", content_list.toString())
            type_list.add(model.alert_type)
            Log.e("at", type_list.toString())

            recycler_view.setLayoutManager(LinearLayoutManager(context))
            recycler_view.setAdapter(Details_adapter(context,content_list,type_list))

                }
            }
    catch (e: JSONException) {
        e.printStackTrace()
    }
    }

    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("notificationdetails_json.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }
}