package com.example.kings_demo.activities.notifications.model

import com.google.gson.annotations.SerializedName

class Notification_datalists (
@SerializedName("id") val id: Int,
@SerializedName("title") val title: String,
@SerializedName("alert_type") val alert_type: String,
@SerializedName("read_unread_status") val read_unread_status: Int

)