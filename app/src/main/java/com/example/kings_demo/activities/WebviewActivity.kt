package com.example.kings_demo.activities

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.kings_demo.R
import com.github.barteksc.pdfviewer.PDFView

class WebviewActivity: AppCompatActivity() {
    lateinit var context: Context
    private lateinit var webView: WebView
    var urltoshow: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview_activity)
        urltoshow = intent.getStringExtra("web_url").toString()
        webView=findViewById(R.id.webview)
        context = this
        Log.e("url", urltoshow)
        webView.webViewClient = WebViewClient()
        webView.loadUrl(urltoshow)
        webView.settings.javaScriptEnabled = true

    }
}