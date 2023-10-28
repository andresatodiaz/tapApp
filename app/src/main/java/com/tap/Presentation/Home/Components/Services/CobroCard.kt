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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tap.Data.Entities.Cobro
import com.tap.Presentation.Cobrar.CobrarDialog
import com.tap.Presentation.Pagar.PagarDialog
import com.tap.ui.theme.debt
import com.tap.ui.theme.incoming
import com.tap.ui.theme.mainBlue
import com.tap.ui.theme.pagado
import com.tap.ui.theme.secondaryBlue

@Composable
fun CobroCard(
    cobro: Cobro,
    navController: NavController
) {
    val openDialog = remember{ mutableStateOf(false) }
    if(openDialog.value){
        CobrarDialog(cobro = cobro, openDialog = openDialog,navController)
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
            modifier= Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(cobro.nombre, fontWeight = FontWeight.Black)
            Spacer(modifier = Modifier.padding(top=20.dp))
            Box(
                modifier= Modifier
                    .background(
                        secondaryBlue,
                        CircleShape
                    )
                    .padding(10.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(text = "S/. "+cobro.precio)

            }
            Spacer(modifier = Modifier.padding(top=20.dp))
            Row(
                modifier= Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(cobro.fecha)
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "next",tint= mainBlue)
            }

        }
    }
}