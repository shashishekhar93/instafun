package com.tech.instafun.retrofit

import com.tech.instafun.model.ResponseData
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitApiService {

    @GET("videos/popular")
    suspend fun getPopularVideos(
        @Header("Authorization") apiKey: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): ResponseData
}