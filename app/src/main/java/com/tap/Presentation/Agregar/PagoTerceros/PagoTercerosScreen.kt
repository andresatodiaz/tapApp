package com.tap.Presentation.Agregar.PagoTerceros

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tap.ui.theme.mainBlue
import com.tap.ui.theme.secondaryBlue

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PagoTercerosScreen(

) {
    val codigo = remember{ mutableStateOf("") }
    val opcionBanco = remember{ mutableStateOf(0) }
    val pagoAutomatico = remember{ mutableStateOf(0) }
    val openDialog = remember{ mutableStateOf(false) }
    val expanded = remember{ mutableStateOf(false) }
    val daysList = (1..31).toList()
    val daysSelection = remember{ mutableStateOf(1) }

    Scaffold(

        modifier= Modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.9f),
        floatingActionButton = {
            Button(
                colors=ButtonDefaults.buttonColors(
                    containerColor = mainBlue
                ),
                modifier=Modifier.fillMaxWidth(0.9f),
                onClick = { /*TODO*/ }) {
                Text("Crear",modifier=Modifier.padding(10.dp))
            }
        }
    ) {
        Column(
            modifier= Modifier.fillMaxWidth(0.9f)
        ) {
            Row(
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            ){
                Text("Agregar servicio", fontWeight = FontWeight.Bold)
            }
            Text("Cuenta de beneficiario", fontWeight = FontWeight.Bold)
            Row(

            ){
                Button(
                    colors=ButtonDefaults.buttonColors(
                        containerColor = if(opcionBanco.value==0) mainBlue else secondaryBlue,
                        contentColor = if(opcionBanco.value==0) Color.White else mainBlue
                    ),
                    onClick = { opcionBanco.value=0 }) {
                    Text("Mismo banco")
                }
                Spacer(Modifier.padding(end=20.dp))
                Button(
                    colors=ButtonDefaults.buttonColors(
                        containerColor = if(opcionBanco.value==1) mainBlue else secondaryBlue,
                        contentColor = if(opcionBanco.value==1) Color.White else mainBlue
                    ),
                    onClick = { opcionBanco.value=1}) {
                    Text("Interbancario")
                }
            }
            OutlinedTextField(
                modifier= Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxWidth(),
                label={
                    Text(text="Código")
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = mainBlue,
                    containerColor = Color.Transparent
                ),
                trailingIcon = {
                    if(codigo.value.isNotEmpty()){
                        Icon(imageVector = Icons.Default.Clear, contentDescription = "clear",modifier=Modifier.clickable {
                            codigo.value=""
                        })
                    }

                },
                value = codigo.value, onValueChange = {codigo.value=it},
                shape = CircleShape
            )
            Text("Día del pago del mes",modifier=Modifier.padding(top=20.dp),fontWeight = FontWeight.Bold)
            Text("En caso, el día no calce con el mes se adelantará al día más cercano")
            LazyRow(
                modifier=Modifier.fillMaxWidth()
            ){
                items(daysList){day->
                    Box(
                        modifier= Modifier
                            .padding(10.dp)
                            .background(
                                if (daysSelection.value == day) secondaryBlue else Color.Transparent,
                                CircleShape
                            )
                            .clickable {
                                daysSelection.value = day
                            }
                            .size(30.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Text(day.toString())
                    }
                }
            }
            Text("Pago automático",modifier=Modifier.padding(top=20.dp),fontWeight = FontWeight.Bold)
            Row(

            ){
                Button(
                    colors=ButtonDefaults.buttonColors(
                        containerColor = if(pagoAutomatico.value==0) mainBlue else secondaryBlue,
                        contentColor = if(pagoAutomatico.value==0) Color.White else mainBlue
                    ),
                    onClick = { pagoAutomatico.value=0 }) {
                    Text("Si")
                }
                Spacer(Modifier.padding(end=20.dp))
                Button(
                    colors=ButtonDefaults.buttonColors(
                        containerColor = if(pagoAutomatico.value==1) mainBlue else secondaryBlue,
                        contentColor = if(pagoAutomatico.value==1) Color.White else mainBlue
                    ),
                    onClick = { pagoAutomatico.value=1}) {
                    Text("No")
                }
            }



        }
    }




}