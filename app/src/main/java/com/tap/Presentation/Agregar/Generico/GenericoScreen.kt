package com.tap.Presentation.Agregar.Generico

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import com.tap.Data.Entities.Service
import com.tap.R
import com.tap.ui.theme.mainBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenericoScreen(

) {
    val serviceList = listOf(Service("Luz del Sur",153.30,"Pendiente","28/09"), Service("Entel",39.90,"Pagado","27/10"), Service("Sedapal",101.90,"Próximo","30/10"))
    val searchText = remember{ mutableStateOf("") }
    val searchList = remember{ mutableStateOf(emptyList<Service>()) }

    LaunchedEffect(key1 = searchText.value ){
        searchList.value=serviceList.filter {
            it.nombre.toLowerCase().contains(searchText.value.toLowerCase())
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
                        Card(
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
                                Text(service.nombre)
                                Button(
                                    colors= ButtonDefaults.buttonColors(
                                        containerColor = mainBlue
                                    ),
                                    modifier = Modifier.size(50.dp),
                                    contentPadding = PaddingValues(0.dp),
                                    shape = CircleShape,
                                    onClick = { /*TODO*/ }) {
                                    Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar")
                                }
                            }

                        }
                        Spacer(Modifier.padding(bottom=20.dp))
                    }
                }else{
                    items(serviceList){service->
                        Card(
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
                                Text(service.nombre)
                                Button(
                                    colors= ButtonDefaults.buttonColors(
                                        containerColor = mainBlue
                                    ),
                                    modifier = Modifier.size(50.dp),
                                    contentPadding = PaddingValues(0.dp),
                                    shape = CircleShape,
                                    onClick = { /*TODO*/ }) {
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