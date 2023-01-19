package com.example.androidunittesting.room

import androidx.room.Embedded
import androidx.room.Relation

data class OptionWithPros(
    @Embedded val option: Option,
    @Relation(
        parentColumn = "id",
        entityColumn = "option_id"
    )
    val pros: List<Pro>
) {
    fun totalScore(): Int {
        return this.pros.sumOf { it.rating.num }
    }

    fun betterThan(other: OptionWithPros): Boolean {
        return this.totalScore() > other.totalScore()
    }
}
