package com.jorge.chargegridapi.station.dto

import com.jorge.chargegridapi.station.Status
import jakarta.validation.constraints.NotNull

data class StationStatusUpdateRequest(
    @field:NotNull(message = "Status must not be null")
    val status: Status
)
