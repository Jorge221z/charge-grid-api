package com.jorge.chargegridapi.station

import com.jorge.chargegridapi.station.dto.StationCreateRequest
import com.jorge.chargegridapi.station.dto.StationResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/stations")
class StationController(
    private val stationService: StationService
) {

    @PostMapping
    fun createStation(@Valid @RequestBody request: StationCreateRequest): ResponseEntity<StationResponse> {

        val savedStation = stationService.createStation(request)

        val responseDto = StationResponse(
            id = savedStation.id!!, // Assume that station ID is not null anymore (fail-fast)
            name = savedStation.name,
            latitude = savedStation.latitude,
            longitude = savedStation.longitude,
            maxPower = savedStation.maxPower,
            status = savedStation.status
        )

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto)
    }


    @GetMapping("/{id}")
    fun getStation(@Valid @PathVariable id: Long): ResponseEntity<StationResponse> {

        val savedStation = stationService.getStation(id)

        val responseDto = StationResponse(
            id = savedStation.id!!,
            name = savedStation.name,
            latitude = savedStation.latitude,
            longitude = savedStation.longitude,
            maxPower = savedStation.maxPower,
            status = savedStation.status
        )

        return ResponseEntity.status(HttpStatus.OK).body(responseDto)
    }


}