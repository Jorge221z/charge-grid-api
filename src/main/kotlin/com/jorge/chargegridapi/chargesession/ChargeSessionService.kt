package com.jorge.chargegridapi.chargesession

import com.jorge.chargegridapi.chargesession.dto.StartSessionRequest
import com.jorge.chargegridapi.station.StationService
import com.jorge.chargegridapi.station.Status
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class ChargeSessionService(
    private val chargeSessionRepository: ChargeSessionRepository,
    private val stationService: StationService,
) {

    @Transactional
    fun startSession(request: StartSessionRequest): ChargeSession {

        val savedStation = stationService.getStation(request.stationId)

        if (savedStation.status != Status.AVAILABLE) {
            throw ResponseStatusException(
                HttpStatus.CONFLICT, "Station not currently available to be used") // 409
        }

        savedStation.status = Status.IN_USE
        val chargeSession = ChargeSession(station = savedStation)

        return chargeSessionRepository.save(chargeSession)
    }

}