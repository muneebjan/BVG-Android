package com.example.bvgnativ.data.model

import com.google.gson.annotations.SerializedName

data class DeparturesResponse(
    val departures: List<Departure>,
    val realtimeDataUpdatedAt: Long
)

data class Departure(
    val tripId: String?,
    val direction: String?,
    val line: Line?,
    @SerializedName("when") val whenTime: String?, // 'when' is a reserved word
    val plannedWhen: String?,
    val delay: Int?
)

data class Line(
    val id: String?,
    val name: String?,
    val mode: String?,
    val product: String?
)
