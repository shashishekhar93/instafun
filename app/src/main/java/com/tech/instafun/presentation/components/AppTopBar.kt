package com.tech.instafun.presentation.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tech.instafun.R
import com.tech.instafun.ui.theme.blackColor
import com.tech.instafun.ui.theme.whiteColor

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        colors = TopAppBarDefaults.topAppBarColors(containerColor = whiteColor),
        title = {
            Text(
                text = title,
                color = blackColor,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.headlineMedium,
            )
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_camera),
                    contentDescription = null,
                    tint = blackColor,
                    modifier = Modifier.size(21.dp)
                )
            }
        }
    )
}