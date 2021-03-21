package com.danieljrodrigues.github.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.danieljrodrigues.github.data.Repository

class MainViewModelFactoryProvider(
    val repository: Repository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}