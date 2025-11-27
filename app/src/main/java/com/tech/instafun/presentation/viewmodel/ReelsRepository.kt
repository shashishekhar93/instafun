package com.tech.instafun.presentation.viewmodel

import com.tech.instafun.BuildConfig
import com.tech.instafun.retrofit.RetrofitApiService

class ReelsRepository(private val apiService: RetrofitApiService) {
    suspend fun getReels() = apiService.getPopularVideos(BuildConfig.API_KEY,1,15)
}