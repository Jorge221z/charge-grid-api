package com.jorge.chargegridapi.chargesession

import com.jorge.chargegridapi.station.Station

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.time.Duration


@Entity
@Table(name = "charge_sessions")
class ChargeSession(

    val startTime: LocalDateTime = LocalDateTime.now(),
    var endTime: LocalDateTime? = null,

    var kwhConsumed: Double = 0.0, // Start value

    // Owning side of the relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id", nullable = false)
    val station: Station
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun calculatePowerConsumed (): Double {

        val end = this.endTime ?: LocalDateTime.now() // Safer
        val duration = Duration.between(this.startTime, end)
        val hoursElapsed = duration.toMinutes() / 60.0 // e.g. 30 mins = 0.5 hours

        val rawKwh = this.station.maxPower * hoursElapsed // (10 Kw * 0.5 hours) = 5 kWh
        return Math.round(rawKwh * 100.0) / 100.0
    }
}

