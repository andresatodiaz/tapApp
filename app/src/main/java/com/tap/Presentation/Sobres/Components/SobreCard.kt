package com.tap.Presentation.Sobres.Components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SobreCard(
    sobre:String,
    color: Color,
    selected: MutableState<String>
) {
    Card(
        shape= RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp),
        modifier= Modifier
            .height(50.dp)
            .width(100.dp)
            .padding(end=10.dp)
            .clickable { selected.value=sobre }
            .border(if(selected.value==sobre) 2.dp else 0.dp, Color.Black,RoundedCornerShape(20.dp,20.dp,0.dp,0.dp)),
        colors = CardDefaults.cardColors(
            containerColor = color,
            contentColor = Color.White
        )
    ) {
        Box(
            modifier=Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(sobre, fontWeight = FontWeight.Bold)
        }
    }
}