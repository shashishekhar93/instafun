package com.tech.instafun.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ReelsViewModelFactory (private val repository: ReelsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReelsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ReelsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}