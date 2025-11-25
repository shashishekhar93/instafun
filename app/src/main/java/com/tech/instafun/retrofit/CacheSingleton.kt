package com.tech.instafun.retrofit

import android.annotation.SuppressLint
import android.content.Context
import androidx.media3.common.util.UnstableApi
import androidx.media3.database.StandaloneDatabaseProvider
import androidx.media3.datasource.cache.LeastRecentlyUsedCacheEvictor
import androidx.media3.datasource.cache.SimpleCache
import java.io.File

@UnstableApi
object CacheSingleton {

    private var simpleCache: SimpleCache? = null

    @SuppressLint("UnsafeOptInUsageError")
    fun getCache(context: Context): SimpleCache {
        return simpleCache ?: synchronized(this) {
            simpleCache ?: run {
                val cacheSize = 100L * 1024 * 1024 //its 100 MB
                val cacheDir = File(context.cacheDir, "media_cache")
                val databaseProvider = StandaloneDatabaseProvider(context.applicationContext)
                SimpleCache(
                    cacheDir,
                    LeastRecentlyUsedCacheEvictor(cacheSize),
                    databaseProvider
                ).also { simpleCache = it }
            }
        }
    }


   /* @SuppressLint("UnsafeOptInUsageError")
    fun getCache(context: Context): SimpleCache {
        if (simpleCache == null) {
            val cacheSize = 100L * 1024 * 1024
            val cacheDir = File(context.cacheDir, "media_cache")
            val databaseProvider = StandaloneDatabaseProvider(context)
            simpleCache = SimpleCache(
                cacheDir,
                LeastRecentlyUsedCacheEvictor(cacheSize),
                databaseProvider
            )
        }
        return simpleCache!!
    }*/
}