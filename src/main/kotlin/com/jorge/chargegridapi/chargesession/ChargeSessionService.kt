package com.jorge.chargegridapi.chargesession

import com.jorge.chargegridapi.chargesession.dto.StartSessionRequest
import com.jorge.chargegridapi.station.StationService
import com.jorge.chargegridapi.station.Status
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

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

    @Transactional
    fun stopSession(sessionId: Long): ChargeSession {

        val currentSession = chargeSessionRepository.findByIdOrNull(sessionId) ?:
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Session with ID $sessionId not found") // 404

        if (currentSession.endTime != null) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Session already stopped") // 400
        }

        currentSession.endTime = LocalDateTime.now()
        currentSession.kwhConsumed = currentSession.calculatePowerConsumed()
        currentSession.station.status = Status.AVAILABLE

        return chargeSessionRepository.save(currentSession)
    }

}