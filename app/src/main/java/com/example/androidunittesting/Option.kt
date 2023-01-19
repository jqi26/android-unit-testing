package com.example.androidunittesting

class Option(var name: String) {
    private var pros: ArrayList<Pro> = arrayListOf()

    fun totalScore(): Int {
        return this.pros.sumOf { it.rating.num }
    }
    
    fun betterThan(other: Option): Boolean {
        return this.totalScore() > other.totalScore()
    }

    fun addPro(pro: Pro) {
        pros.add(pro)
    }
}