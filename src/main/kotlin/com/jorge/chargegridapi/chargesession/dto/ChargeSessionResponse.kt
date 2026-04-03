package com.jorge.chargegridapi.chargesession.dto

import java.time.LocalDateTime

data class ChargeSessionResponse(
    val id: Long,
    val stationId: Long,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime?,
    val kwhConsumed: Double
)
