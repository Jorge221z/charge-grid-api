package com.jorge.chargegridapi.station.dto

import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

/**
 * Fields allowed by the backend via HTTP requests
 */
data class StationCreateRequest(
    @field:NotBlank(message = "Name must not be blank")
    val name: String,

    @field:DecimalMin(value = "-90.0", message = "Latitude must be greater than or equal to -90.0")
    @field:DecimalMax(value = "90.0", message = "Latitude must be less than or equal to 90.0")
    val latitude: Double,

    @field:DecimalMin(value = "-180.0", message = "Longitude must be greater than or equal to -180.0")
    @field:DecimalMax(value = "180.0", message = "Longitude must be less than or equal to 180.0")
    val longitude: Double,

    @field:Positive(message = "Max power must be positive")
    val maxPower: Double,
)
