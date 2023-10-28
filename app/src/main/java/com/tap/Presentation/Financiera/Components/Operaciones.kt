package com.tap.Presentation.Financiera.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tap.ui.theme.mainBlue
import com.tap.ui.theme.secondaryBlue
import com.tap.ui.theme.tertiaryBlue

@Composable
fun Operaciones (){
    Card(
        colors= CardDefaults.cardColors(
            contentColor = mainBlue,
            containerColor = tertiaryBlue
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Column {
                Text("Andrés Kei", fontWeight = FontWeight.Bold)
                Text("22/10/2023")
            }

            Text("S/. 100")
        }
    }
}