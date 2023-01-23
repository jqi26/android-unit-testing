package com.example.androidunittesting

class DistanceHelper(private val close: Double, private val medium: Double, private val far: Double) {
    fun getRange(distance: Double): Range {
        val result: Range

        if (distance < 0) {
            throw java.lang.IllegalArgumentException("Distance cannot be negative.")
        }

        if (distance <= this.close) {
            result = Range.CLOSE
        } else if (distance <= this.medium) {
            result = Range.MEDIUM
        } else if (distance <= this.far) {
            result = Range.FAR
        } else {
            result = Range.TOO_FAR
        }

        return result
    }

    init {
        if (close < 0) {
            throw java.lang.IllegalArgumentException("First argument cannot be negative")
        } else if (medium < 0) {
            throw java.lang.IllegalArgumentException("Second argument cannot be negative")
        } else if (far < 0) {
            throw java.lang.IllegalArgumentException("Third argument cannot be negative")
        } else if (close >= medium) {
            throw java.lang.IllegalArgumentException("First argument should be less than the second argument")
        } else if (close >= far) {
            throw java.lang.IllegalArgumentException("First argument should be less than the third argument")
        } else if (medium >= far) {
            throw java.lang.IllegalArgumentException("Second argument should be less than the third argument")
        }
    }
}