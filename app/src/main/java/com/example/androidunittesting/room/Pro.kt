package com.example.androidunittesting.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Pro(
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "rating") var rating: Rating,
    @ColumnInfo(name = "option_id") val optionId: Long,
    ) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0

    enum class Rating(val num: Int) {
        LOW(1),
        MEDIUM(2),
        HIGH(3)
    }
}