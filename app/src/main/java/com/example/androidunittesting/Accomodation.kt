package com.example.androidunittesting

class Accomodation {
    private var pros: ArrayList<Pro> = arrayListOf()

    fun totalScore(): Int {
        return this.pros.sumOf { it.rating.num }
    }
    
    fun betterThan(other: Accomodation): Boolean {
        return this.totalScore() > other.totalScore()
    }

    fun addPro(pro: Pro) {
        pros.add(pro)
    }
}