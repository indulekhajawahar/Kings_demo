package com.example.kings_demo.activities.notifications.model

import com.google.gson.annotations.SerializedName

class Notification_model(
    @SerializedName("status") val status: String,
    @SerializedName("message") var message: String,
    @SerializedName("validation_errors") val validationErrorArray: List<ValidationError>,
    @SerializedName("data") val data: Data_notification
)