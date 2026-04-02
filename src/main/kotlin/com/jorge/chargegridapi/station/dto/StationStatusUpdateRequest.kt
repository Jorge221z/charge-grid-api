package com.jorge.chargegridapi.station.dto

import com.jorge.chargegridapi.station.Status

data class StationStatusUpdateRequest(
    val status: Status
)
