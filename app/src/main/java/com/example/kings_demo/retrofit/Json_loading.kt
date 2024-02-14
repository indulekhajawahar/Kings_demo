package com.example.kings_demo.retrofit

import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.nio.charset.Charset

class Json_loading : AppCompatActivity() {
     fun loadJSONFromAsset(file_name:String): String {
        val json: String?
        try {
            val inputStream = assets.open(file_name)
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