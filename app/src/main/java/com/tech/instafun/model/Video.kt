package com.tech.instafun.model


import com.google.gson.annotations.SerializedName

data class Video(
    @SerializedName("height")
    val height: Int,
    @SerializedName("width")
    val width: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("user")
    val user: User,
    @SerializedName("video_files")
    val videoFiles: List<VideoFile>
)