package com.example.bvgnativ.data.model

data class Stop(
    val type: String?,
    val id: String?,
    val name: String?,
    val location: Location?,
    val products: Products?
)

data class Location(
    val type: String?,
    val id: String?,
    val latitude: Double?,
    val longitude: Double?
)

data class Products(
    val suburban: Boolean? = false,
    val subway: Boolean? = false,
    val tram: Boolean? = false,
    val bus: Boolean? = false
)
