package com.tech.instafun.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


private val LightColorPalette = lightColorScheme(
    primary = primaryColor,
    primaryContainer = greyColor,
    secondary = lightGreyColor,
    secondaryContainer = primaryColor,
)

@Composable
fun ReelsAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}