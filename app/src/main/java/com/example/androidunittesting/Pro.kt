package com.example.androidunittesting

class Pro(private var description: String, var rating: Rating) {

    enum class Rating(val num: Int) {
        LOW(1),
        MEDIUM(2),
        HIGH(3)
    }
}