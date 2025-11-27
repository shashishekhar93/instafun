package com.tech.instafun.presentation.components

import android.widget.Toast
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.tech.instafun.presentation.reels.VideoPlayer
import com.tech.instafun.presentation.viewmodel.ReelsViewModel

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReelsList(viewModel: ReelsViewModel) {
    val context = LocalContext.current
    //val reels = remember { DummyData.reels }
    val reels by viewModel.reels.observeAsState(emptyList())
    val size by remember { mutableStateOf(100.dp) }
    var isLike by remember { mutableStateOf(false) }

    val pager = rememberPagerState(
        initialPage = 0,
        //pageCount = { reels.value?.size!! }
        pageCount = {reels.size }
    )

    val animatedSize by animateDpAsState(
        targetValue = if (isLike) size else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy,
            stiffness = 500f
        )
    )

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (favIcon, reelsPager) = createRefs()
        VerticalPager(
            state = pager,
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(reelsPager) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        ) { index ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onDoubleTap = {
                                Toast.makeText(
                                    context,
                                    "Double Tapped",
                                    Toast.LENGTH_SHORT
                                ).show()
//                                isLike = true
//                                reels[index] = reels[index].copy(isLiked = true)
                            },
                            onTap = {
                                Toast.makeText(
                                    context,
                                    "Tapped",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        )
                    }) {
                VideoPlayer(url = reels[index].videoFiles[0].link)
               // reels.value?.get(index)?.videoFiles?.get(0)?.link?.let { VideoPlayer(url = it) }
                //VideoPlayer(url = reels[index].video)
                Column(Modifier.align(Alignment.BottomStart)) {
                    ReelsFooter(reels.get(index).user)
                    //reels.value?.get(index)?.let { ReelsFooter(it.user) }
                    HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
                }
            }
        }

        //like functionality.
        /*if (isLike) {
            Icon(
                painterResource(R.drawable.ic_favorite_fill),
                tint = Color.Red,
                modifier = Modifier
                    .size(animatedSize)
                    .constrainAs(favIcon) {
                        centerHorizontallyTo(reelsPager)
                        centerVerticallyTo(reelsPager)
                    },
                contentDescription = ""
            )
            if (animatedSize == size) {
                isLike = false
            }
        }*/

    }

}
