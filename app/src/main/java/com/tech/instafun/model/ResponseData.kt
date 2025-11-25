package com.tech.instafun.model


import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("next_page")
    val nextPage: String,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("videos")
    val videos: List<Video>
)