package com.tap.Presentation.Home.Components.Account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tap.R
import com.tap.ui.theme.mainBlue

@Composable
fun AccountCard(
    modifier: Modifier,
    showMoney:Boolean
) {
    Card(
        modifier= modifier.fillMaxWidth(),
        colors =CardDefaults.cardColors(
            containerColor = mainBlue,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ){
        Column(
            modifier=Modifier.padding(20.dp)
        ) {
            Row(
                modifier=Modifier.fillMaxWidth()
            ){
                Text("Cuenta sueldo soles", fontWeight = FontWeight.Bold)
            }
            Row(
                modifier=Modifier.padding(top=20.dp)
            ){
                Icon(painter = painterResource(id = R.drawable.money), contentDescription = "money" )
                Spacer(Modifier.padding(start=20.dp))
                Text(if(showMoney) "10,000 soles" else "****")
            }
            Row(
                modifier=Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Row(
                ){
                    Text("* * * * 3038")
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Icon(painter = painterResource(id = R.drawable.next), contentDescription = "more")
                }

            }
        }

    }
}