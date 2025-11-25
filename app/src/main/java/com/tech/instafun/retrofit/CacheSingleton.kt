package com.tech.instafun.retrofit

import android.annotation.SuppressLint
import android.content.Context
import androidx.media3.datasource.cache.LeastRecentlyUsedCacheEvictor
import androidx.media3.datasource.cache.SimpleCache
import java.io.File

object CacheSingleton {
    @SuppressLint("UnsafeOptInUsageError")
    private var simpleCache: SimpleCache? = null
    @SuppressLint("UnsafeOptInUsageError")
    fun getCache(context: Context): SimpleCache {
        if (simpleCache == null) {
            val cacheSize = 100L * 1024 * 1024
            val cacheDir = File(context.cacheDir, "media_cache")
            simpleCache = SimpleCache(cacheDir, LeastRecentlyUsedCacheEvictor(cacheSize))
        }
        return simpleCache!!
    }
}