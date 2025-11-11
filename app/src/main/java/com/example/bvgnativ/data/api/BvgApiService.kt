package com.example.bvgnativ.data.api

import com.example.bvgnativ.data.model.Departure
import com.example.bvgnativ.data.model.Stop
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BvgApiService {

    @GET("locations")
    suspend fun getLocations(
        @Query("query") query: String
    ): List<Stop>

    @GET("stops/{stopId}/departures")
    suspend fun getDepartures(
        @Path("stopId") stopId: String
    ): List<Departure>
}
