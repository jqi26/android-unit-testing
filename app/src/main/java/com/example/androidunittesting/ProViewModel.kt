package com.example.androidunittesting

//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.androidunittesting.room.OptionRepository
//import com.example.androidunittesting.room.OptionWithPros
//
//class ProViewModel(var selectedOption: OptionWithPros, private val repository: OptionRepository): ViewModel()  {
//}
//
//class ProViewModelFactory(var selectedOption: OptionWithPros, private val repository: OptionRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(ProViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return ProViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}