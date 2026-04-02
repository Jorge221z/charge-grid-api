package com.jorge.chargegridapi.station.dto


/**
 * Fields that the mobile app needs to display a station properly
 */
data class StationResponse(
    val id: Long,
    var name: String,
    var latitude: Double,
    var longitude: Double,
    var maxPower: Double,
    var status: String,
)
