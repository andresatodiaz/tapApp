package com.tap.Presentation.Home.Components.Account

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.tap.R
import com.tap.ui.theme.mainBlue
import com.tap.ui.theme.secondaryBlue

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun AccountCarrousel(

) {
    // ACTUAL OFFSET
    fun PagerState.offsetForPage(page: Int) = (currentPage - page) + currentPageOffset

    // OFFSET ONLY FROM THE LEFT
    fun PagerState.startOffsetForPage(page: Int): Float {
        return offsetForPage(page).coerceAtLeast(0f)
    }

    // OFFSET ONLY FROM THE RIGHT
    fun PagerState.endOffsetForPage(page: Int): Float {
        return offsetForPage(page).coerceAtMost(0f)
    }

    val pagerState = rememberPagerState(5)
    val showMoney = remember{mutableStateOf(false)}

    Row(
        modifier=Modifier.fillMaxWidth()
            .padding(bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(){
            Text("Mis cuentas", fontWeight = FontWeight.Black, fontSize = 16.sp)
        }
        Row(){
            Button(
                onClick = {
                    showMoney.value=!showMoney.value
                },
                shape = CircleShape,
                modifier = Modifier.size(50.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = secondaryBlue
                )
            ) {
                Icon(painter = painterResource(id = if(showMoney.value) R.drawable.hidepass else R.drawable.showpass), contentDescription = "user",tint= mainBlue )
            }
            Spacer(Modifier.padding(start=10.dp))
            Button(
                onClick = { /*TODO*/ },
                shape = CircleShape,
                modifier = Modifier.size(50.dp),
                contentPadding = PaddingValues(0.dp),
                colors =ButtonDefaults.buttonColors(
                    containerColor = secondaryBlue
                )
            ) {
                Icon(imageVector = Icons.Default.List, contentDescription = "list",tint= mainBlue)
            }
        }

    }

    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {

        HorizontalPager(state = pagerState, itemSpacing = 10.dp) { page ->
            AccountCard(modifier=if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.S) {
                Modifier.graphicsLayer {
                    val startOffset = pagerState.startOffsetForPage(page)
                    //translationX = size.width * (startOffset * .99f)

                    alpha = (2f - startOffset) / 2f
                    val blur = (startOffset * 20f).coerceAtLeast(0.1f)
                    renderEffect = RenderEffect
                        .createBlurEffect(
                            blur, blur, Shader.TileMode.DECAL
                        ).asComposeRenderEffect()

                    val scale = 1f - (startOffset * .1f)
                    scaleX = scale
                    scaleY = scale
                }
            } else Modifier,
                showMoney = showMoney.value
            )
        }
    }
    Row(
        Modifier
            .height(20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val current = pagerState.currentPage
            val color = if(current == iteration) mainBlue else secondaryBlue
            val width = if ( current == iteration)  10.dp else 5.dp
            Box(
                modifier = Modifier
                    .animateContentSize(
                        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
                    )
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .height(5.dp)
                    .width(width)

            )
        }
    }
}