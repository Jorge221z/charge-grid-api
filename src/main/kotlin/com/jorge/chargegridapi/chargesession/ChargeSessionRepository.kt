package com.jorge.chargegridapi.chargesession

import org.springframework.data.jpa.repository.JpaRepository


interface ChargeSessionRepository: JpaRepository<ChargeSession, Long> {
    // No additional methods needed yet
}