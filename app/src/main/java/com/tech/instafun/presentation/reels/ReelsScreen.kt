package com.tech.instafun.presentation.reels

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tech.instafun.presentation.components.AppBottomNavigation
import com.tech.instafun.presentation.components.AppTopBar
import com.tech.instafun.presentation.components.ReelsList
import com.tech.instafun.presentation.viewmodel.ReelsViewModel
import com.tech.instafun.ui.theme.lightGreyColor

@Preview
@Composable
fun ReelsScreen(viewModel: ReelsViewModel) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { AppTopBar(title = "Insta Fun") },
        bottomBar = { AppBottomNavigation() }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues = paddingValues)) {
            Box(
                Modifier
                    .background(color = lightGreyColor, shape = RoundedCornerShape(20.dp))
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .clip(RoundedCornerShape(15.dp))
            ) {
                ReelsList(viewModel)
            }
        }
    }
}

