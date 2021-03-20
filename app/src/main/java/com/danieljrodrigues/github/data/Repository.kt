package com.danieljrodrigues.github.data

import com.danieljrodrigues.github.data.Network.RetrofitInstance

class Repository {

    suspend fun getEvents(name: String) = RetrofitInstance.api.getEventsFeed("danielj06")

}