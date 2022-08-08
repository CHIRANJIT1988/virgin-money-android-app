package com.virgin.money.data.api

import com.virgin.money.data.models.People
import com.virgin.money.data.models.Room
import retrofit2.Response
import retrofit2.http.GET

interface VirginMoneyApi {

    @GET("/api/v1/people")
    suspend fun getPeoples() : Response<List<People>>?

    @GET("/api/v1/rooms")
    suspend fun getRooms() : Response<List<Room>>?
}
