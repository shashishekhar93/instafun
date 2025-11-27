package com.tech.instafun

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
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

                    val reels by viewmodel.reels.observeAsState(initial = emptyList())
                    val isLoading by viewmodel.loading.observeAsState(initial = false)
                    val error by viewmodel.error.observeAsState()

                    // 3. Trigger one-time events using LaunchedEffect
                    // This fetches the reels only once when the composable first appears.
                    LaunchedEffect(key1 = Unit) {
                        viewmodel.fetchReelsFromRemoteSource()
                    }

                    // This is for showing side effects like Toasts
                    /*LaunchedEffect(isLoading) {
                        Toast.makeText(
                            this@ReelsActivity,
                            "isLoading is = $isLoading",
                            Toast.LENGTH_SHORT
                        ).show()
                    }*/

                    LaunchedEffect(error) {
                        error?.let {
                            Log.d("TAG", "error: $it")
                            Toast.makeText(this@ReelsActivity, it, Toast.LENGTH_SHORT).show()
                        }
                    }

                    //ReelsScreen(viewmodel)
                    if (isLoading) {
                        Box(
                            Modifier
                                .fillMaxSize()
                                .background(Color.Black.copy(alpha = 0.3f)),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(modifier = Modifier.size(64.dp)) // Smaller spinner
                        }
                    } else {
                        ReelsScreen(viewmodel)
                    }

//                    ReelsLoadingState(viewmodel)
                }
            }
        }
    }


    /*@Composable
    fun ReelsLoadingState(viewModel: ReelsViewModel) {
        val isLoading by viewModel.loading.observeAsState(initial = false)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp) // Limit height to video section only
                .padding(horizontal = 16.dp) // Match your reels container padding
        ) {
            if (isLoading) {
                // Shimmer only in this bounded area
                ShimmerReelItem()
            } else {
                // Real reels content here
                ReelsScreen(viewModel = viewModel)
            }
        }
    }

    @Composable
    fun ShimmerReelItem() {
        val infiniteTransition = rememberInfiniteTransition()
        val shimmerAlpha = infiniteTransition.animateFloat(
            initialValue = 0.4f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(1200),
                repeatMode = RepeatMode.Reverse
            )
        )
        // Smaller size, multiple items for reels effect
        Column {
            Box(
                modifier = Modifier
                    .fillMaxSize() // Fill the container it's placed in
                    .background(
                        Color.Gray.copy(alpha = shimmerAlpha.value),
                        RoundedCornerShape(12.dp)
                    )
            )
        }
    }
*/
}