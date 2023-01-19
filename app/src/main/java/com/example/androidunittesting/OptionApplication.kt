package com.example.androidunittesting

import android.app.Application
import com.example.androidunittesting.room.OptionDatabase
import com.example.androidunittesting.room.OptionRepository

class OptionApplication: Application() {
    val database by lazy { OptionDatabase.getDatabase(this) }
    val repository by lazy { OptionRepository(database.optionDao()) }
}