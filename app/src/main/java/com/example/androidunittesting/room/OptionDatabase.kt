package com.example.androidunittesting.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Option::class, Pro::class], version = 1)
abstract class OptionDatabase : RoomDatabase() {
    abstract fun optionDao(): OptionDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: OptionDatabase? = null

        fun getDatabase(context: Context): OptionDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    OptionDatabase::class.java,
                    "options_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}