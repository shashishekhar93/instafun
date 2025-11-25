package com.tech.instafun.utils

import androidx.compose.runtime.mutableStateListOf
import com.tech.instafun.model.Reel

object DummyData {

    val reels = mutableStateListOf(
        Reel(
            id = 1,
            video = "https://videos.pexels.com/video-files/5386411/5386411-hd_1080_2048_25fps.mp4",
            userImage = "https://eliteadmin.themedesigner.in/demos/bt4/university/dist/images/users/11.jpg",
            userName = "Raju Rastogi",
            isLiked = true,
            likesCount = 778,
            commentsCount = 156,
            comment = "What an amazing view ..."
        ),
        Reel(
            id = 2,
            video = "https://videos.pexels.com/video-files/7438482/7438482-hd_720_1248_30fps.mp4",
            userImage = "https://eliteadmin.themedesigner.in/demos/bt4/university/dist/images/users/11.jpg",
            userName = "Riddhi Sagar Singh",
            isLiked = false,
            likesCount = 5923,
            commentsCount = 11,
            comment = "What an amazing view ..."
        ),
        Reel(
            id = 3,
            video = "https://videos.pexels.com/video-files/1526909/1526909-hd_1280_720_24fps.mp4",
            userImage = "https://eliteadmin.themedesigner.in/demos/bt4/university/dist/images/users/11.jpg",
            userName = "Radha Yadav",
            isLiked = true,
            likesCount = 2314,
            comment = "What an amazing view ...",
            commentsCount = 200
        ),
        Reel(
            id = 4,
            video = "https://moedata.000webhostapp.com/4.mp4",
            userImage = "https://eliteadmin.themedesigner.in/demos/bt4/university/dist/images/users/11.jpg",
            userName = "Muhammad Ali",
            isLiked = false,
            likesCount = 786,
            comment = "What an amazing view ...",
            commentsCount = 700
        ),
        Reel(
            id = 5,
            video = "https://moedata.000webhostapp.com/5.mp4",
            userImage = "https://eliteadmin.themedesigner.in/demos/bt4/university/dist/images/users/11.jpg",
            userName = "Peter Parker",
            isLiked = true,
            likesCount = 1890,
            comment = "What an amazing view ...",
            commentsCount = 232
        )
    )
}