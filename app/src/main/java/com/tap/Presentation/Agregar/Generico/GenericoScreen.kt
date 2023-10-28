package com.tap.Presentation.Agregar.Generico

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.tap.Data.Entities.Service
import com.tap.Presentation.Notification.Notification
import com.tap.R
import com.tap.ui.theme.mainBlue
import com.tap.ui.theme.secondaryOrange
import com.tap.ui.theme.tertiaryBlue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100)
        delay(10)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenericoScreen(

) {
    val serviceList = listOf(Service("Luz del Sur",153.30,"Pendiente","28/09"), Service("Entel",39.90,"Pagado","27/10"), Service("Sedapal",101.90,"Próximo","30/10"),Service("Luz del Norte",153.30,"Pendiente","28/09"),Service("Chepupu",153.30,"Pendiente","28/09"),
            Service("Agua del Sur",153.30,"Pendiente","28/09"),Service("Luz del Este",153.30,"Pendiente","28/09"))
    val searchText = remember{ mutableStateOf("") }
    val searchList = remember{ mutableStateOf(emptyList<Service>()) }
    val scope = rememberCoroutineScope()
    val add = remember{ mutableStateOf(false) }
    val loadingCompletion = remember{ mutableStateOf(0f) }
    val context = LocalContext.current
    val selectedNombre = remember{ mutableStateOf("") }

    LaunchedEffect(key1 = searchText.value ){
        searchList.value=serviceList.filter {
            it.nombre.toLowerCase().contains(searchText.value.toLowerCase())
        }
    }



    LaunchedEffect(key1 = add.value ){
        if(add.value==true){
            delay(2000)
            add.value=false
            Notification(context = context ).showBasicNotification("Tap","Se ha añadido el servicio")
        }
    }

    if(add.value){
        Dialog(onDismissRequest = { /*TODO*/ }) {
            Column(
                modifier= Modifier
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .padding(20.dp)
            ) {
                Spacer(Modifier.padding(10.dp))
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth(),
                    progress = loadingCompletion.value
                )
                Spacer(Modifier.padding(10.dp))
                Text("Gracias por ingresar sus datos", fontWeight = FontWeight.Bold,modifier=Modifier.padding(bottom=20.dp))
                Text("Agregando servicio...", fontWeight = FontWeight.Normal)
            }
        }
    }

    Column(
        modifier=Modifier.fillMaxWidth(0.9f)
    ) {
        OutlinedTextField(
            modifier= Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth(),
            label={
                  Text("Búsqueda")
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = mainBlue,
                containerColor = Color.Transparent
            ),
            trailingIcon = {
                if(searchText.value.length>0){
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "clear",modifier=Modifier.clickable {
                        searchText.value=""
                    })
                }

            },
            value = searchText.value, onValueChange = {searchText.value=it},
            shape = CircleShape
        )
        if(searchList.value.isEmpty() && searchText.value!=""){
            Text("No hay ese servicio",modifier=Modifier.padding(top=20.dp, bottom = 20.dp))
        }else{
            LazyColumn(
                contentPadding = PaddingValues(bottom=100.dp)
            ){
                if(searchList.value.isNotEmpty()){
                    items(searchList.value){service->
                        val automatico = remember{ mutableStateOf(false)}
                        Card(
                            colors=CardDefaults.cardColors(
                                containerColor = if(selectedNombre.value==service.nombre) secondaryOrange else tertiaryBlue
                            ),
                            modifier=Modifier.fillMaxWidth(),
                            shape= RoundedCornerShape(20.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp)
                            ){
                                Column(){
                                    Text(service.nombre, fontWeight = FontWeight.Black,modifier=Modifier.padding(top=10.dp,bottom=10.dp))
                                    Button(
                                        colors=ButtonDefaults.buttonColors(
                                            containerColor = mainBlue,
                                            contentColor = Color.White
                                        ),
                                        onClick = { automatico.value=!automatico.value }) {
                                        Text(if(automatico.value) "Automático" else "No automatico",modifier=Modifier.padding(5.dp))
                                    }
                                }

                                Button(
                                    colors= ButtonDefaults.buttonColors(
                                        containerColor = mainBlue
                                    ),
                                    modifier = Modifier.size(50.dp),
                                    contentPadding = PaddingValues(0.dp),
                                    shape = CircleShape,
                                    onClick = {
                                        selectedNombre.value=service.nombre
                                        add.value=true
                                        scope.launch {
                                            loadProgress{ progress ->
                                                loadingCompletion.value = progress
                                            }
                                        }
                                    }) {
                                    Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar")
                                }
                            }

                        }
                        Spacer(Modifier.padding(bottom=20.dp))
                    }
                }else{
                    items(serviceList){service->
                        val automatico = remember{ mutableStateOf(false)}
                        Card(
                            colors=CardDefaults.cardColors(
                                containerColor = if(selectedNombre.value==service.nombre) secondaryOrange else tertiaryBlue
                            ),
                            modifier=Modifier.fillMaxWidth(),
                            shape= RoundedCornerShape(20.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp)
                            ){
                                Column(){
                                    Text(service.nombre, fontWeight = FontWeight.Black,modifier=Modifier.padding(top=10.dp,bottom=10.dp))
                                    Button(
                                        colors=ButtonDefaults.buttonColors(
                                            containerColor = mainBlue,
                                            contentColor = Color.White
                                        ),
                                        onClick = { automatico.value=!automatico.value }) {
                                        Text(if(automatico.value) "Automático" else "No automatico",modifier=Modifier.padding(5.dp))
                                    }
                                }

                                Button(
                                    colors= ButtonDefaults.buttonColors(
                                        containerColor = mainBlue
                                    ),
                                    modifier = Modifier.size(50.dp),
                                    contentPadding = PaddingValues(0.dp),
                                    shape = CircleShape,
                                    onClick = {
                                        selectedNombre.value=service.nombre
                                        add.value=true
                                        scope.launch {
                                            loadProgress{ progress ->
                                                loadingCompletion.value = progress
                                            }
                                        }
                                    }) {
                                    Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar")
                                }
                            }

                        }
                        Spacer(Modifier.padding(bottom=20.dp))
                    }
                }

            }
        }

    }
}