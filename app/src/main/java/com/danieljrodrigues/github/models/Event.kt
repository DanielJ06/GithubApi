package com.danieljrodrigues.github.models


import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("actor")
    val actor: Actor,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("payload")
    val payload: Payload,
    @SerializedName("public")
    val `public`: Boolean,
    @SerializedName("repo")
    val repo: Repo,
    @SerializedName("type")
    val type: String
)