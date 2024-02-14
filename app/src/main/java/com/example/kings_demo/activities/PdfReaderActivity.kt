package com.example.kings_demo.activities

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import com.downloader.PRDownloaderConfig
import com.example.kings_demo.R
import com.github.barteksc.pdfviewer.PDFView
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class PdfReaderActivity:AppCompatActivity() {
    lateinit var context: Context
    lateinit var pdf_view: PDFView
    lateinit var pdf_downloadbutton: ImageView
    lateinit var progressBar: ProgressBar
    var urltoshow: String = ""
    var filename: String = "dwnld.pdf"
    private val STORAGE_PERMISSION_CODE: Int = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pdf_reader)
        urltoshow = intent.getStringExtra("pdf_url").toString()
        pdf_view = findViewById(R.id.pdfview)
        pdf_downloadbutton = findViewById(R.id.pdf_download_button)
        context = this
        val config = PRDownloaderConfig.newBuilder()
            .setReadTimeout(30000)
            .setConnectTimeout(30000)
            .build()
        PRDownloader.initialize(applicationContext, config)
        Log.e("url", urltoshow)

         RetrievePDFFromURL(pdf_view).execute(urltoshow)

        pdf_downloadbutton.setOnClickListener() {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                requestPermissions(
                    arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    STORAGE_PERMISSION_CODE
                )
            }
            val fileWithinMyDir = File(getFilepath("$title.pdf"))
            if (fileWithinMyDir.exists()) {
                fileWithinMyDir.delete()
                startdownloading()
                onDownloadComplete()
            } else {
                startdownloading()
                onDownloadComplete()
            }
        }
    }

    private fun getFilepath(filename: String): String? {
        return File(
            Environment.getExternalStorageDirectory().absolutePath,
            "/Download/$filename"
        ).path
    }

    private fun startdownloading() {
        val request = DownloadManager.Request(Uri.parse(urltoshow))   //URL = URL to download
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
        request.setTitle("Download")
        request.setDescription("The file is downloading...")
        request.allowScanningByMediaScanner()
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "$title.pdf")
        // pdfprogress.visibility = View.VISIBLE
        val manager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        manager.enqueue(request)
    }

    fun onDownloadComplete() {
        val onComplete = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                // pdfprogress.visibility = View.GONE
                Toast.makeText(context, "File downloaded", Toast.LENGTH_SHORT).show()

            }

        }
        registerReceiver(onComplete, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
    }
    class RetrievePDFFromURL(pdfView: PDFView) :
        AsyncTask<String, Void, InputStream>() {

        val mypdfView: PDFView = pdfView

        override fun doInBackground(vararg params: String?): InputStream? {
            var inputStream: InputStream? = null
            try {
                val url = URL(params.get(0))
                val urlConnection: HttpURLConnection = url.openConnection() as HttpsURLConnection

                if (urlConnection.responseCode == 200) {
                    inputStream = BufferedInputStream(urlConnection.inputStream)
                }
            }
            catch (e: Exception) {
                e.printStackTrace()
                return null;
            }
            return inputStream;
        }
        override fun onPostExecute(result: InputStream?) {
            mypdfView.fromStream(result).load()

        }
    }
}


