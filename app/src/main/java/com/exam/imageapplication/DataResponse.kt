package com.exam.imageapplication

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataResponse(

    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("status")
    val status: String
)