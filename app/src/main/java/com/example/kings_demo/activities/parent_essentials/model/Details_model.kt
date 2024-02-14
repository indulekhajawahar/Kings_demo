package com.example.kings_demo.activities.parent_essentials.model

import com.example.kings_demo.activities.notifications.model.ValidationError
import com.google.gson.annotations.SerializedName

class Details_model (
    @SerializedName("status") val status: String,
@SerializedName("message") var message: String,
@SerializedName("validation_errors") val validationErrorArray: List<ValidationError>,
@SerializedName("data") val data: Data_details
)