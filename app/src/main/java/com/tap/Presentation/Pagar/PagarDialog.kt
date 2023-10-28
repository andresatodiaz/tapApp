package com.tap.Presentation.Pagar

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.tap.Data.Entities.Service
import com.tap.Presentation.Notification.Notification
import com.tap.ui.theme.mainBlue
import com.tap.ui.theme.secondaryBlue

@Composable
fun PagarDialog(
    service: Service,
    openDialog: MutableState<Boolean>,
    navController: NavController
) {
    val context = LocalContext.current
    Dialog(onDismissRequest = { openDialog.value=false}) {
        Column(
            modifier= Modifier
                .background(Color.White, RoundedCornerShape(20.dp))
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().clickable {
                    if(service.fecha!=null){
                        navController.navigate("serviceScreen/${service.nombre}/${service.precio.toInt().toString()}/${service.fecha.replace("/",",")}/true")

                    }
                },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(service.nombre, fontWeight = FontWeight.Bold, fontSize =16.sp)
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription ="more",tint= mainBlue )
            }

            Row(
                modifier=Modifier.fillMaxWidth()
                    .padding(top=30.dp,bottom=30.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Box(
                    modifier=Modifier.background(secondaryBlue, CircleShape)
                ){
                    Text("S/."+service.precio, fontWeight = FontWeight.Bold,modifier=Modifier.padding(20.dp), fontSize = 18.sp)
                }
            }

            Row(
                modifier=Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(
                    colors=ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = mainBlue
                    ),
                    modifier=Modifier.border(2.dp, mainBlue, CircleShape)
                        .weight(1f)
                        .height(50.dp),
                    onClick = {
                        openDialog.value=false
                    }) {
                    Text("Cancelar", fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.padding(10.dp))
                Button(
                    modifier=Modifier.weight(1f)
                        .height(50.dp),
                    colors=ButtonDefaults.buttonColors(
                        containerColor = mainBlue,
                        contentColor = Color.White
                    ),
                    onClick = {
                        Notification(context = context ).showBasicNotification("Tap","Pago satisfactorio!")
                    }) {
                    Text("Pagar", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}