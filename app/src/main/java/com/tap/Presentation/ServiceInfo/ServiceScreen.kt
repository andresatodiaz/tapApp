package com.tap.Presentation.ServiceInfo

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tap.ui.theme.mainBlue
import com.tap.ui.theme.secondaryBlue
import com.tap.ui.theme.tertiaryBlue

@Composable
fun ServiceScreen(
    nombre:String,
    precio:String,
    fecha:String,
    operaciones:String,
    navController: NavController
){
    if(operaciones=="true"){
        Column(
            modifier=Modifier.fillMaxWidth(0.9f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier= Modifier
                    .fillMaxWidth(0.9f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier= Modifier
                        .background(tertiaryBlue, RoundedCornerShape(20.dp))
                        .fillMaxWidth(0.8f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Spacer(Modifier.padding(10.dp))
                    Text(nombre, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Spacer(Modifier.padding(10.dp))
                    Box(
                        modifier= Modifier
                            .background(secondaryBlue, RoundedCornerShape(20.dp))
                    ){
                        Text("S/. "+precio.toString(), modifier = Modifier.padding(20.dp), fontWeight = FontWeight.Black, fontSize = 18.sp)
                    }
                    Spacer(Modifier.padding(10.dp))
                    Row() {
                        Text("Fecha: ")
                        Text(text = fecha.replace(",","/"), fontSize = 15.sp, fontStyle = FontStyle.Italic)
                    }
                    Spacer(Modifier.padding(10.dp))

                }


            }

            Row(
                modifier=Modifier.padding(top=20.dp,bottom=20.dp)
            ){
                Text("Mis operaciones", fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
            }

            Column {
                Card(
                    colors=CardDefaults.cardColors(
                        contentColor = secondaryBlue,
                        containerColor = mainBlue
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

                        Text("S/. "+(precio.toInt()+5).toString())
                    }
                }
                Spacer(modifier = Modifier.padding(top=10.dp))
                Card(colors=CardDefaults.cardColors(
                    contentColor = secondaryBlue,
                    containerColor = mainBlue
                ),
                    shape = RoundedCornerShape(20.dp)
                ){
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
                        Text("S/. "+(precio.toInt()+5).toString())
                    }
                }
            }
        }

    }else{
        Column(
            modifier= Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.8f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier= Modifier
                    .background(tertiaryBlue, RoundedCornerShape(20.dp))
                    .fillMaxWidth(0.8f)
                    .height(500.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text(nombre, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(Modifier.padding(10.dp))
                Box(
                    modifier= Modifier
                        .background(secondaryBlue, RoundedCornerShape(20.dp))
                ){
                    Text("S/. "+precio.toString(), modifier = Modifier.padding(20.dp), fontWeight = FontWeight.Black, fontSize = 18.sp)
                }
                Spacer(Modifier.padding(10.dp))
                Row() {
                    Text("Fecha: ")
                    Text(text = fecha.replace(",","/"), fontSize = 15.sp, fontStyle = FontStyle.Italic)
                }
                Spacer(Modifier.padding(10.dp))
                Button(
                    colors=ButtonDefaults.buttonColors(
                        containerColor = mainBlue,
                        contentColor = Color.White
                    ),
                    onClick = {
                        navController.navigate("vida")
                    }) {
                    Text("Volver",modifier=Modifier.padding(10.dp))
                }
            }


        }
    }

}