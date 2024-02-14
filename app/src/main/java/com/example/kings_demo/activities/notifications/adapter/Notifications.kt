package com.example.kings_demo.activities.notifications.adapter

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kings_demo.R
import com.example.kings_demo.activities.notifications.model.Notification_datalists
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class Notifications: AppCompatActivity() {
    lateinit var context:Context
    lateinit var lists: ArrayList<String>
   lateinit var title_list: ArrayList<String>
    lateinit var alert_type_list: ArrayList<String>
    lateinit var recycler_view:RecyclerView
    lateinit var type_list: ArrayList<String>
    lateinit var content_list: ArrayList<String>
lateinit var page_title:TextView

    val mp4: String = ".mp4"
    val jpg: String = ".jpg"
    val mp3: String = ".mp3"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification)
        context=this
        lists = ArrayList()
        title_list = ArrayList()
        alert_type_list = ArrayList()
        content_list = ArrayList()
        type_list = ArrayList()
        recycler_view=findViewById(R.id.notification_recycler)
        page_title=findViewById(R.id.title_notification)
        callNotificationList()

        }
   private fun callNotificationList(){
        try {
            val obj = JSONObject(loadJSONFromAsset())
            val data = obj.getJSONObject("data")
            Log.e("dt", data.toString())
            val listsArray = data.getJSONArray("lists")
            Log.e("ar", listsArray.toString())

            for (i in 0..3 ) {
                val list = listsArray.getJSONObject(i)
                val id:Int=list.getInt("id")
                val title:String=list.getString("title")
                val alert_type:String=list.optString("alert_type")
                val read_unread_status:Int=list.getInt("read_unread_status")

                val model=Notification_datalists(id,title,alert_type,read_unread_status)

                title_list.add(model.title)
                Log.e("title", title_list.toString())
                alert_type_list.add(model.alert_type)
                Log.e("at", alert_type_list.toString())

            }

            recycler_view.setLayoutManager(LinearLayoutManager(context))
            recycler_view.setAdapter(Notification_adapter(context,title_list,alert_type_list))

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("Notification_json.json")
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