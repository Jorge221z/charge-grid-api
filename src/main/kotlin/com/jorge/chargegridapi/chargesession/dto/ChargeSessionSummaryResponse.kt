package com.jorge.chargegridapi.chargesession.dto

import java.time.LocalDateTime

// No stationId since sessions already have a Station object
data class ChargeSessionSummaryResponse(
    val id: Long,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime?,
    val kwhConsumed: Double,
)
