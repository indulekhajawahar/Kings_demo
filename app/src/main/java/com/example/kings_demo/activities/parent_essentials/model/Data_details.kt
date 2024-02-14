package com.example.kings_demo.activities.parent_essentials.model

import com.google.gson.annotations.SerializedName

class Data_details (
        @SerializedName("id") val id: Int,
        @SerializedName("title") var title: String,
        @SerializedName("url") var url: String
        )