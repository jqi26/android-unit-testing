package com.example.androidunittesting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidunittesting.room.Option
import com.example.androidunittesting.room.OptionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OptionViewModel(private val repository: OptionRepository): ViewModel() {
    var options = repository.optionWithPros.asLiveData()

    fun addOption(option: Option) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addOption(option)
        }
    }
}

class OptionViewModelFactory(private val repository: OptionRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OptionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OptionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}