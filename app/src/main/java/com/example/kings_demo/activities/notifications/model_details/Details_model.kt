package com.example.kings_demo.activities.notifications.model_details

import com.example.kings_demo.activities.notifications.model.Data_notification
import com.example.kings_demo.activities.notifications.model.ValidationError
import com.google.gson.annotations.SerializedName

class Details_model (
@SerializedName("status") val status: Int,
@SerializedName("message") val message: String,
@SerializedName("validation_errors") val validationErrorArray: List<ValidationError>,
@SerializedName("data") val data: Data_details
)