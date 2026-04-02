package com.jorge.chargegridapi.station

import com.jorge.chargegridapi.station.dto.StationCreateRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


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

    fun getStation(id: Long): Station {
     return stationRepository.findByIdOrNull(id) ?: throw ResponseStatusException(
         HttpStatus.NOT_FOUND, "Station with ID $id not found") // 404
    }

    fun getAllStations(): List<Station> {
        return stationRepository.findAll()
    }

    fun updateStationStatus(id: Long, status: Status): Station {
        val station = getStation(id)
        station.status = status
        return stationRepository.save(station)
    }
}