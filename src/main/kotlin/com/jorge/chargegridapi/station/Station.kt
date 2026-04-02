package com.jorge.chargegridapi.station

import com.jorge.chargegridapi.chargesession.ChargeSession
import jakarta.persistence.*


@Entity
@Table(name = "stations")
class Station(
    // Constructor parameters
    var name: String = "",

    var latitude: Double = 0.0,

    var longitude: Double = 0.0,

    var maxPower: Double = 0.0,

    @Enumerated(EnumType.STRING)
    var status: Status = Status.AVAILABLE,

    @OneToMany(mappedBy = "station", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val chargeSessions: MutableList<ChargeSession> = mutableListOf()
) {
    // Attributes that are auto-generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}

enum class Status {
    AVAILABLE,
    IN_USE,
    MAINTENANCE
}