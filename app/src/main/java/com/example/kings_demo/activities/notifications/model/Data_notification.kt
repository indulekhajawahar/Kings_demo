package com.example.kings_demo.activities.notifications.model

import com.google.gson.annotations.SerializedName

class Data_notification(
    @SerializedName("lists") val lists: ArrayList<Notification_datalists>
)