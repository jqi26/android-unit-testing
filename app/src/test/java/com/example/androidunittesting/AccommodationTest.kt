package com.example.androidunittesting

import com.example.androidunittesting.room.Option
import com.example.androidunittesting.room.Pro
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AccommodationTest {
    lateinit var accom1: Option
    lateinit var accom2: Option

    @Before
    fun resetAccomodations() {
        accom1 = Option("")
        accom2 = Option("")
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