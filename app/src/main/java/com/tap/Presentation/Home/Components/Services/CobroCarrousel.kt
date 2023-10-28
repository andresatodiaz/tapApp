package com.tap.Presentation.Home.Components.Services

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.tap.Data.Entities.Cobro
import com.tap.R
import com.tap.ui.theme.mainBlue
import com.tap.ui.theme.secondaryBlue

@Composable
fun CobroCarrousel(
    cobroList: List<Cobro>,
    navController: NavController
) {
    val showList = remember{ mutableStateOf(false) }
    if(showList.value){
        Dialog(
            onDismissRequest = { showList.value=false},
        ) {
            Column(
                modifier= Modifier
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .padding(10.dp)
                    .heightIn(300.dp,500.dp)
            ) {
                Row(
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    horizontalArrangement = Arrangement.End
                ){
                    Button(
                        colors=ButtonDefaults.buttonColors(
                            containerColor = mainBlue
                        ),
                        onClick = { showList.value=false }
                    ) {
                        Text(text = "Cerrar")
                        Icon(imageVector = Icons.Default.Close, contentDescription = "close")
                    }
                }
                LazyVerticalGrid(columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    items(cobroList){cobro->
                        CobroCard(cobro = cobro,navController)
                        Spacer(Modifier.padding(10.dp))
                    }
                }
            }
        }
    }

    Row(modifier= Modifier
        .fillMaxWidth()
        .padding(top = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text("Cobranza", fontWeight = FontWeight.Black, modifier = Modifier.padding(bottom=20.dp,top=20.dp))
        Row(){
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = secondaryBlue
                ),
                onClick = {
                    showList.value=!showList.value
                }) {
                Icon(painter = painterResource(id = R.drawable.grid), contentDescription = "grid",tint= mainBlue)
            }
            Spacer(modifier = Modifier.padding(end=10.dp))
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = mainBlue
                ),
                onClick = {
                    navController.navigate("agregarPagoTerceros")
                }
            ) {
                Text("Agregar +",color= Color.White)
            }
        }
    }
    LazyRow(
        modifier= Modifier.fillMaxWidth(),
    ){
        items(cobroList){cobro->
            CobroCard(cobro,navController)
            Spacer(modifier = Modifier.padding(end=20.dp))
        }
    }

}