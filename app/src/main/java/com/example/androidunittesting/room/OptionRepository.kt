package com.example.androidunittesting.room

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class OptionRepository(private val optionDao: OptionDao) {
    val optionWithPros: Flow<List<OptionWithPros>> = optionDao.getOptionsWithPros()

    suspend fun addOption(option: Option) {
        optionDao.addOption(option)
    }

    fun optionWithPros(id: Long): Flow<OptionWithPros> {
        return optionDao.getOptionWithPros(id)
    }

    suspend fun addPro(pro: Pro) {
        optionDao.addPro(pro)
    }
}