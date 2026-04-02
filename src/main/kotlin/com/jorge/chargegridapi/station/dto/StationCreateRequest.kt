package com.jorge.chargegridapi.station.dto


/**
 * Fields allowed by the backend via HTTP requests
 */
data class StationCreateRequest(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val maxPower: Double,
)
