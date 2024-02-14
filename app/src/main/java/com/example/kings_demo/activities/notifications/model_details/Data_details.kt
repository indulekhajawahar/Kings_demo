package com.example.kings_demo.activities.notifications.model_details

import com.example.kings_demo.activities.notifications.model.Notification_datalists
import com.google.gson.annotations.SerializedName

class Data_details (
    @SerializedName("lists") val lists: ArrayList<Details_datalists>
)