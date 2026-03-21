package com.jorge.chargegridapi.station

import org.springframework.data.jpa.repository.JpaRepository

interface StationRepository: JpaRepository<Station, Long> {

    fun findByName(name: String): Station?

    fun findByLatitudeAndLongitude(latitude: Double, longitude: Double): Station?

    fun findByStatus(status: Status): List<Station>

}