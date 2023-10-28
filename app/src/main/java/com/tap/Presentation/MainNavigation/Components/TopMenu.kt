package com.tap.Presentation.MainNavigation.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tap.R
import com.tap.ui.theme.mainBlue
import com.tap.ui.theme.secondaryBlue

@Composable
fun TopMenu(

){
    Row(
        modifier= Modifier.fillMaxWidth()
            .height(80.dp)
            .padding(top=10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row(
            modifier=Modifier.padding(start=20.dp)
        ) {
           Image(painter = painterResource(id = R.drawable.taplogo), contentDescription = "taplogo",modifier=Modifier.size(80.dp))
        }

    }
}