package com.jorge.chargegridapi

import jakarta.persistence.*


@Entity
@Table(name = "stations")
class Station(
    // Constructor parameters
    var name: String = "",

    var latitude: Double = 0.0,

    var longitude: Double = 0.0,

    @Enumerated(EnumType.STRING)
    var status: Status = Status.AVAILABLE
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