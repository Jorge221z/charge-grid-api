package com.jorge.chargegridapi.station.dto

import com.jorge.chargegridapi.chargesession.dto.ChargeSessionSummaryResponse
import com.jorge.chargegridapi.station.Status

data class StationDetailResponse(
    val id: Long,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val maxPower: Double,
    val status: Status,
    val recentSessions: List<ChargeSessionSummaryResponse>
)
