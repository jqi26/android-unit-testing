package com.example.androidunittesting

import org.junit.Assert.*
import org.junit.Test

class RentHelperTest {
    @Test
    fun zeroDollarsTest() {
        assertEquals(0.0, RentHelper.maxRentFor(0), 0.01)
    }

    @Test
    fun oneDollarTest() {
        assertEquals(0.3, RentHelper.maxRentFor(1), 0.01)
    }

    @Test
    fun typicalAmountTest() {
        assertEquals(429.6, RentHelper.maxRentFor(1432), 0.01)
    }

    @Test
    fun negativeNumberThrowsIllegalArgumentExceptionTest() {
        assertThrows(java.lang.IllegalArgumentException::class.java) {
            RentHelper.maxRentFor(-1)
        }
    }

    @Test
    fun negativeNumberHasCorrectErrorMessageTest() {
        try {
            RentHelper.maxRentFor(-1)
            fail("Did not get exception for negative number.")
        } catch (e: java.lang.Exception) {
            assertEquals("Weekly income cannot be a negative number.", e.message)
        }
    }
}