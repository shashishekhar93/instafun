package com.tech.instafun.presentation.viewmodel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech.instafun.model.Video
import kotlinx.coroutines.launch

class ReelsViewModel(private val reelsRepository: ReelsRepository) : ViewModel() {

    // LiveData or StateFlow to expose reels data and loading state
    private val _reels = MutableLiveData<List<Video>>()
    var reels: LiveData<List<Video>> = _reels

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchReelsFromRemoteSource() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                val response = reelsRepository.getReels()
                _reels.value = response.videos
            } catch (e: Exception) {
                _error.value = "Exception: ${e.localizedMessage}"
            }
            _loading.value = false
        }
    }
}