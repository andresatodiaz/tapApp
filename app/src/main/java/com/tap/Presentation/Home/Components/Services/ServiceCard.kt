package com.tap.Presentation.Home.Components.Services

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tap.Data.Entities.Service
import com.tap.Presentation.Pagar.PagarDialog
import com.tap.ui.theme.debt
import com.tap.ui.theme.incoming
import com.tap.ui.theme.pagado
import com.tap.ui.theme.secondaryBlue

@Composable
fun ServiceCard(
    service:Service
) {
    val openDialog = remember{ mutableStateOf(false) }
    if(openDialog.value){
        PagarDialog(service = service, openDialog = openDialog)
    }
    Card (
        shape= RoundedCornerShape(20.dp),
        modifier= Modifier
            .width(150.dp)
            .clickable {
                openDialog.value=true
            }
    ){
        Column(
            modifier=Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(service.nombre, fontWeight = FontWeight.Black)
            Spacer(modifier = Modifier.padding(top=20.dp))
            Box(
                modifier= Modifier
                    .background(
                        if (service.estado == "Pendiente") {
                            debt
                        } else {
                            if (service.estado == "Pagado") {
                                pagado
                            } else {
                                incoming
                            }
                        },
                        CircleShape
                    )
                    .padding(10.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                if(service.estado!=null){
                    Row(){
                        Text(service.estado,color= Color.White)
                    }
                }else{
                    Row(){
                        Text("S/."+service.precio.toString(),color= Color.White)
                    }
                }

            }
            Spacer(modifier = Modifier.padding(top=20.dp))
            if(service.fecha!=null){
                Row(
                    modifier=Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(service.fecha)
                    Text("S/. "+service.precio, fontWeight = FontWeight.Black)
                }
            }else if(service.codigo!=null){
                Row(
                    modifier=Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(service.codigo)
                }
            }

        }
    }
}