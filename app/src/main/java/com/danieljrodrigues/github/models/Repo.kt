package com.danieljrodrigues.github.models


import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)