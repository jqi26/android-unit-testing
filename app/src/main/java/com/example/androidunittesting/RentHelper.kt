package com.example.androidunittesting

class RentHelper {
    companion object {
        fun maxRentFor(weeklyIncomeDollars: Int): Double {
            if (weeklyIncomeDollars < 0) {
                throw java.lang.IllegalArgumentException("Weekly income cannot be a negative number.")
            }

            return weeklyIncomeDollars * 0.3
        }
    }
}