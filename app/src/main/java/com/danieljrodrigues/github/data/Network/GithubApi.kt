package com.danieljrodrigues.github.data.Network

import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    @GET("/users/{username}/received_events")
    suspend fun getEventsFeed(
        @Path("username") username: String
    ) : Any

}