package com.danieljrodrigues.github.data

import com.danieljrodrigues.github.data.Network.RetrofitInstance
import com.danieljrodrigues.github.models.Event
import retrofit2.Response

class Repository {

    suspend fun getEvents(username: String): Response<List<Event>> {
        return RetrofitInstance.api.getEventsFeed(username)
    }

}