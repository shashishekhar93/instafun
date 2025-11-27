package com.tech.instafun.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tech.instafun.model.Reel
import com.tech.instafun.model.User

@Preview
@Composable
//fun ReelsFooter(reel: Reel) {
fun ReelsFooter(user: User) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 18.dp, bottom = 18.dp),
        verticalAlignment = Alignment.Bottom
    ) {

        FooterUserData(
            user = user,
            modifier = Modifier.weight(8f)
        )

        //contains like share options which appear on side.
//        RightUserActions(
//            reel = reel,
//            modifier = Modifier.weight(8f)
//        )
    }
}