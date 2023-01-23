package com.example.androidunittesting

import androidx.lifecycle.*
import com.example.androidunittesting.room.Option
import com.example.androidunittesting.room.OptionRepository
import com.example.androidunittesting.room.OptionWithPros
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OptionViewModel(private val repository: OptionRepository): ViewModel() {
    var options = repository.optionWithPros.asLiveData()
    var selectedOption: LiveData<OptionWithPros>? = null

    fun addOption(option: Option) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addOption(option)
        }
    }

    fun updateSelectedOption(id: Long) {
        selectedOption = repository.optionWithPros(id).asLiveData()
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