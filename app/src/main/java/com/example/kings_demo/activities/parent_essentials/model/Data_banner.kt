package com.example.kings_demo.activities.parent_essentials.model

import com.google.gson.annotations.SerializedName

class Data_banner  (
@SerializedName("banner_image") val banner_image: String,
@SerializedName("description") var description: String,
@SerializedName("contact_email") var contact_email: String
)