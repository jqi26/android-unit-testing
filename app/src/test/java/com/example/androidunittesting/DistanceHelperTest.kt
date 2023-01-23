package com.example.androidunittesting

import org.junit.Assert.*
import org.junit.Test

class DistanceHelperTest {
    private val helper = DistanceHelper(3.0, 5.0, 10.0)

    @Test
    fun negativeDistanceThrowsIllegalArgumentExceptionTest() {
        assertThrows(java.lang.IllegalArgumentException::class.java) {
            helper.getRange(-1.0)
        }
    }

    @Test
    fun negativeDistanceErrorMessageTest() {
        try {
            helper.getRange(-1.0)
            fail("Did not throw exception.")
        } catch (e: java.lang.Exception) {
            assertEquals("Distance cannot be negative.", e.message)
        }
    }

    @Test
    fun zeroIsCloseTest() {
        assertEquals(Range.CLOSE, helper.getRange(0.0))
    }

    @Test
    fun closeExactTest() {
        assertEquals(Range.CLOSE, helper.getRange(3.0))
    }

    @Test
    fun closeTest() {
        assertEquals(Range.CLOSE, helper.getRange(1.5))
    }

    @Test
    fun mediumTest() {
        assertEquals(Range.MEDIUM, helper.getRange(4.0))
    }

    @Test
    fun mediumLowBoundaryTest() {
        assertEquals(Range.MEDIUM, helper.getRange(3.1))
    }

    @Test
    fun mediumExactTest() {
        assertEquals(Range.MEDIUM, helper.getRange(5.0))
    }

    @Test
    fun farTest() {
        assertEquals(Range.FAR, helper.getRange(8.0))
    }

    @Test
    fun farLowBoundaryTest() {
        assertEquals(Range.FAR, helper.getRange(5.1))
    }

    @Test
    fun farExactTest() {
        assertEquals(Range.FAR, helper.getRange(10.0))
    }

    @Test
    fun tooFarLowBoundaryTest() {
        assertEquals(Range.TOO_FAR, helper.getRange(10.1))
    }

    @Test
    fun tooFarTest() {
        assertEquals(Range.TOO_FAR, helper.getRange(15.0))
    }
}