package com.jorge.chargegridapi.station

import com.jorge.chargegridapi.station.dto.StationCreateRequest
import org.springframework.stereotype.Service


@Service
class StationService(
    private val stationRepository: StationRepository,
) {
    fun createStation(request: StationCreateRequest): Station {

        val newStation = Station(
            name = request.name,
            latitude = request.latitude,
            longitude = request.longitude,
            maxPower = request.maxPower,

            // Every new station starts in MAINTENANCE mode until a technician physically verifies it
            status = Status.MAINTENANCE,
        )

        return stationRepository.save(newStation)
    }
}