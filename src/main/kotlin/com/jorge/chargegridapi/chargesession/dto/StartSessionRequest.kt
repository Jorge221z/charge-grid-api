package com.jorge.chargegridapi.chargesession.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull

data class StartSessionRequest(
    // ID of the station requested to be used
    @field:NotNull(message = "Station ID must not be null")
    @field:Min(value = 1, message = "Station ID must be greater than zero")
    val stationId: Long,
)
