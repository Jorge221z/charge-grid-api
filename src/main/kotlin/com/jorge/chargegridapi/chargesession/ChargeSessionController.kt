package com.jorge.chargegridapi.chargesession

import com.jorge.chargegridapi.chargesession.dto.ChargeSessionResponse
import com.jorge.chargegridapi.chargesession.dto.StartSessionRequest
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/sessions")
class ChargeSessionController(
    private val chargeSessionService: ChargeSessionService
) {

    @PostMapping("/start")
    fun startChargeSession(@Valid @RequestBody request: StartSessionRequest): ResponseEntity<ChargeSessionResponse> {

        val chargeSession = chargeSessionService.startSession(request)

        val responseDto = ChargeSessionResponse(
            id = chargeSession.id!!,
            stationId = chargeSession.station.id!!,
            startTime = chargeSession.startTime,
            endTime = chargeSession.endTime,
            kwhConsumed = chargeSession.kwhConsumed,
        )

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto)
    }

    @PostMapping("/{id}/stop")
    fun stopChargeSession(@PathVariable id: Long): ResponseEntity<ChargeSessionResponse> {

        val chargeSession = chargeSessionService.stopSession(id)

        val responseDto = ChargeSessionResponse(
            id = chargeSession.id!!,
            stationId = chargeSession.station.id!!,
            startTime = chargeSession.startTime,
            endTime = chargeSession.endTime,
            kwhConsumed = chargeSession.kwhConsumed,
        )

        return ResponseEntity.status(HttpStatus.OK).body(responseDto)
    }

}