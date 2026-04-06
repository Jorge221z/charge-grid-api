package com.jorge.chargegridapi.chargesession

import com.jorge.chargegridapi.chargesession.dto.StartSessionRequest
import com.jorge.chargegridapi.station.Station
import com.jorge.chargegridapi.station.StationRepository
import com.jorge.chargegridapi.station.StationService
import com.jorge.chargegridapi.station.Status
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException
import kotlin.test.Test
import kotlin.test.assertEquals


@ExtendWith(MockKExtension::class)
class ChargeSessionServiceTest {

    // Declare needed dependencies
    @MockK
    private lateinit var stationRepository: StationRepository

    @MockK
    private lateinit var stationService: StationService

    @MockK
    private lateinit var chargeSessionRepository: ChargeSessionRepository

    // Previous declared mock should point to the class that we are testing in this class
    // Even if we do not need it for some tests, Spring DI does not allow autowire undeclared dependencies
    @InjectMockKs
    private lateinit var chargeSessionService: ChargeSessionService

    @Test
    fun stationUnavailable() {
        // Take advantage of default values so we do not need to specify it
        val dummyStation = Station(
            name = "Test station",
            status = Status.IN_USE,
            maxPower = 24.0
        )

        val requestDto =  StartSessionRequest(stationId = 1L)

        // 'Train' our mocked dependencies
        every { stationService.getStation(1L) } returns dummyStation
        every { stationRepository.findByIdOrNull(1L) } returns dummyStation

        // Tested operation is called here
        val exception = assertThrows<ResponseStatusException> {
            chargeSessionService.startSession(requestDto)
        }

        // To improve test utility we can verify the output
        assertEquals(exception.statusCode, HttpStatus.CONFLICT)
        assertEquals(exception.reason, "Station not currently available to be used")
    }



}