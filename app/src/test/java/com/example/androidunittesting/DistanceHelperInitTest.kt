package com.example.androidunittesting

import org.junit.Assert.*
import org.junit.Test

class DistanceHelperInitTest {

    @Test
    fun distanceHelperInitValidTest() {
        DistanceHelper(3.0, 5.0, 10.0)
    }

    @Test
    fun distanceHelperInitValidBoundaryTest() {
        DistanceHelper(0.1, 0.2, 0.3)
    }

    @Test
    fun smallGreaterThanMediumTest() {
        assertThrows(java.lang.IllegalArgumentException::class.java) {
            DistanceHelper(5.0, 3.0, 10.0)
        }
    }

    @Test
    fun smallEqualToMediumTest() {
        assertThrows(java.lang.IllegalArgumentException::class.java) {
            DistanceHelper(3.0, 3.0, 10.0)
        }
    }

    @Test
    fun smallGreaterThanLargeTest() {
        assertThrows(java.lang.IllegalArgumentException::class.java) {
            DistanceHelper(3.0, 5.0, 2.0)
        }
    }

    @Test
    fun smallEqualToLargeTest() {
        assertThrows(java.lang.IllegalArgumentException::class.java) {
            DistanceHelper(3.0, 5.0, 3.0)
        }
    }

    @Test
    fun mediumGreaterThanLargeTest() {
        assertThrows(java.lang.IllegalArgumentException::class.java) {
            DistanceHelper(3.0, 5.0, 4.0)
        }
    }

    @Test
    fun mediumEqualToLargeTest() {
        assertThrows(java.lang.IllegalArgumentException::class.java) {
            DistanceHelper(3.0, 5.0, 5.0)
        }
    }

    @Test
    fun smallNegativeText() {
        assertThrows(java.lang.IllegalArgumentException::class.java) {
            DistanceHelper(-1.0, 5.0, 10.0)
        }
    }

    @Test
    fun mediumNegativeText() {
        assertThrows(java.lang.IllegalArgumentException::class.java) {
            DistanceHelper(1.0, -5.0, 10.0)
        }
    }

    @Test
    fun largeNegativeText() {
        assertThrows(java.lang.IllegalArgumentException::class.java) {
            DistanceHelper(1.0, 5.0, -10.0)
        }
    }
}