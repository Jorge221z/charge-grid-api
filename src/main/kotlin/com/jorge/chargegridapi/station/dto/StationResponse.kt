package com.jorge.chargegridapi.station.dto

import com.jorge.chargegridapi.station.Status


/**
 * Fields that the mobile app needs to display a station properly
 */
data class StationResponse(
    val id: Long,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val maxPower: Double,
    val status: Status,
)
