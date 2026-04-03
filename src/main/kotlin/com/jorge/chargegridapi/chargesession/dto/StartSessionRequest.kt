package com.jorge.chargegridapi.chargesession.dto

data class StartSessionRequest(
    // ID of the station requested to be used
    val stationId: Long,
)
