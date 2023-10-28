package com.tap.Presentation.Cobrar

import androidx.compose.foundation.Image
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.tap.Data.Entities.Cobro
import com.tap.Presentation.Notification.Notification
import com.tap.R
import com.tap.ui.theme.mainBlue
import com.tap.ui.theme.secondaryBlue

@Composable
fun CobrarDialog(
    cobro: Cobro,
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
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(cobro.nombre, fontWeight = FontWeight.Bold, fontSize =16.sp)
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription ="more",tint= mainBlue )
            }
            Image(painter = painterResource(id = R.drawable.qr), contentDescription = "qr",modifier=Modifier.fillMaxWidth())
            Row(
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, bottom = 30.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Box(
                    modifier= Modifier.background(secondaryBlue, CircleShape)
                ){
                    Text("S/."+cobro.precio, fontWeight = FontWeight.Bold,modifier= Modifier.padding(20.dp), fontSize = 18.sp)
                }
            }

            Column(
                modifier= Modifier.fillMaxWidth()
            ){
                Button(
                    modifier= Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors= ButtonDefaults.buttonColors(
                        containerColor = mainBlue,
                        contentColor = Color.White
                    ),
                    onClick = {
                        navController.navigate(
                            "serviceScreen/${cobro.nombre}/${cobro.precio.toInt().toString()}/${cobro.fecha.replace("/",",")}/true"
                        )
                    }) {
                    Text("Ver pagos", fontWeight = FontWeight.Bold)
                }

                Spacer(Modifier.padding(10.dp))

                Button(
                    colors= ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = mainBlue
                    ),
                    modifier= Modifier
                        .border(2.dp, mainBlue, CircleShape)
                        .height(50.dp)
                        .fillMaxWidth(),
                    onClick = {
                        openDialog.value=false
                    }) {
                    Text("Cancelar", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}