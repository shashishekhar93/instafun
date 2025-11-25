package com.tech.instafun.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tech.instafun.ui.theme.blackColor
import com.tech.instafun.ui.theme.whiteColor
import com.tech.instafun.utils.Screen
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun AppBottomNavigation() {
    val screens = listOf(Screen.Home, Screen.Search, Screen.Create, Screen.Reels, Screen.Profile)
    NavigationBar(
        containerColor = whiteColor,
        tonalElevation = 20.dp,
        modifier = Modifier.height(70.dp),
    ) {
        screens.forEach { screen ->
            NavigationBarItem(
                modifier = Modifier.padding(vertical = 20.dp),
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = screen.title,
                        tint = blackColor,
                        modifier = Modifier.size(22.dp)
                    )
                },
                selected = false,
                onClick = {}
            )
        }

    }
}