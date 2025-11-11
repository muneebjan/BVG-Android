package com.example.bvgnativ.data.repository

import com.example.bvgnativ.data.api.ApiClient
import com.example.bvgnativ.data.model.Departure
import com.example.bvgnativ.data.model.Stop

class BvgRepository {

    private val api = ApiClient.retrofit

    suspend fun getLocations(query: String): List<Stop> {
        return api.getLocations(query)
    }

    suspend fun getDepartures(stopId: String): List<Departure> {
        return api.getDepartures(stopId)
    }
}
