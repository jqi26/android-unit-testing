package com.example.androidunittesting

class DistanceHelper(close: Double, medium: Double, far: Double) {
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