package com.example.androidunittesting.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface OptionDao {
    @Transaction
    @Query("SELECT * FROM Option")
    fun getOptionsWithPros(): Flow<List<OptionWithPros>>

    @Insert
    suspend fun addOption(option: Option)

    @Transaction
    @Query("SELECT * FROM Option WHERE id = :id")
    fun getOptionWithPros(id: Long): Flow<OptionWithPros>

    @Insert
    suspend fun addPro(pro: Pro)
}