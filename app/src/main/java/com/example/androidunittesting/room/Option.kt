package com.example.androidunittesting.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Option(
    @ColumnInfo(name = "name") var name: String,
    ) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}