package com.danieljrodrigues.github.models


import com.google.gson.annotations.SerializedName

data class Payload(
    @SerializedName("action")
    val action: String
)