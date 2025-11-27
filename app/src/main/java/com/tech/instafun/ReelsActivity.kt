package com.tech.instafun

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.tech.instafun.model.Video
import com.tech.instafun.presentation.reels.ReelsScreen
import com.tech.instafun.presentation.viewmodel.ReelsRepository
import com.tech.instafun.presentation.viewmodel.ReelsViewModel
import com.tech.instafun.presentation.viewmodel.ReelsViewModelFactory
import com.tech.instafun.retrofit.RetroFitClient
import com.tech.instafun.ui.theme.ReelsAppTheme


class ReelsActivity : ComponentActivity() {

    private lateinit var viewmodel: ReelsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReelsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val apiService = RetroFitClient().retrofitInstance
                    val repository = ReelsRepository(apiService)
                    val factory = ReelsViewModelFactory(repository)
                    viewmodel = ViewModelProvider(this, factory)[ReelsViewModel::class.java]
                    viewmodel.fetchReelsFromRemoteSource()

                    viewmodel.reels.observe(this, {reelsList->
                        //update UI here.

                    })

                    ReelsScreen(viewmodel)
                    viewmodel.loading.observe(this) { isLoading ->
                        // Show or hide a progress bar or loading indicator
                        if (isLoading) {
                            // show loading
                            //viewmodel.LoadingIndicator(true)
                            Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
                            //LoadingIndicator(isLoading)
                        } else {
                            // hide loading
                            //viewmodel.LoadingIndicator(false)
                            Toast.makeText(this, "Loaded", Toast.LENGTH_SHORT).show()
                        }
                    }

                    viewmodel.error.observe(this) { errorMsg ->
                        errorMsg?.let {
                            // Show an error message to the user, e.g., Toast or Snackbar
                            Log.d("TAG", "error: " +it.toString())
                            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            }
        }
    }
}