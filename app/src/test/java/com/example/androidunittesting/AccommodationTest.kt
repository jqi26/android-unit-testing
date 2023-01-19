package com.example.androidunittesting

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AccommodationTest {
    lateinit var accom1: Accomodation
    lateinit var accom2: Accomodation

    @Before
    fun resetAccomodations() {
        accom1 = Accomodation()
        accom2 = Accomodation()
    }

    @Test
    fun betterThanTest() {
        val pro1 = Pro("", Pro.Rating.HIGH)
        accom1.addPro(pro1)

        val pro2 = Pro("", Pro.Rating.LOW)
        accom2.addPro(pro2)

        assertTrue(accom1.betterThan(accom2))
    }

    @Test
    fun worseThanTest() {
        val pro1 = Pro("", Pro.Rating.LOW)
        accom1.addPro(pro1)

        val pro2 = Pro("", Pro.Rating.HIGH)
        accom2.addPro(pro2)

        assertFalse(accom1.betterThan(accom2))
    }

    @Test
    fun equalTest() {
        val pro1 = Pro("", Pro.Rating.MEDIUM)
        accom1.addPro(pro1)

        val pro2 = Pro("", Pro.Rating.MEDIUM)
        accom2.addPro(pro2)

        assertFalse(accom1.betterThan(accom2))
    }

    @Test
    fun totalTest() {
        val pro1 = Pro("", Pro.Rating.LOW)
        val pro2 = Pro("", Pro.Rating.MEDIUM)
        val pro3 = Pro("", Pro.Rating.HIGH)

        accom1.addPro(pro1)
        accom1.addPro(pro2)
        accom1.addPro(pro3)

        assertEquals(accom1.totalScore(), 6)
    }

    @Test
    fun noProsTotalTest() {
        assertEquals(accom1.totalScore(), 0)
    }
}