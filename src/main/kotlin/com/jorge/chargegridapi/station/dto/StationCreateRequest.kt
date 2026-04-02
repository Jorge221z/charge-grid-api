package com.jorge.chargegridapi.station.dto

import com.jorge.chargegridapi.station.Status

data class StationCreateRequest(
    var name: String,
    var latitude: Double,
    var longitude: Double,
    var maxPower: Double,
)
