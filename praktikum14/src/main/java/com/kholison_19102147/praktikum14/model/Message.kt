package com.kholison_19102147.praktikum14.model

import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("message")
    var message: String? = null
)
