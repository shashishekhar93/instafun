package com.tech.instafun.presentation.reels

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tech.instafun.presentation.components.AppBottomNavigation
import com.tech.instafun.presentation.components.AppTopBar
import com.tech.instafun.presentation.components.ReelsList
import com.tech.instafun.presentation.viewmodel.ReelsRepository
import com.tech.instafun.presentation.viewmodel.ReelsViewModel
import com.tech.instafun.retrofit.RetrofitApiService
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

