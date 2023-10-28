package com.tap.Presentation.Login.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tap.R

@Composable
fun LoginBanner(

) {
    Box(
        modifier= Modifier
            .fillMaxHeight(0.55f)
            .fillMaxWidth()
            .padding(top = 20.dp),
        contentAlignment = Alignment.TopStart
    ){
        Image(painter = painterResource(id = R.drawable.loginbanner),
            contentDescription = "banner",
            modifier= Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(0.dp, 20.dp, 20.dp, 0.dp)),
            contentScale = ContentScale.Crop
        )
        Icon(
            painter = painterResource(id = R.drawable.taplogo),
            contentDescription = "logo",
            tint= Color.White,
            modifier= Modifier
                .padding(top = 10.dp, start = 10.dp)
                .size(180.dp)
        )
    }
}