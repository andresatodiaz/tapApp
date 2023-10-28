package com.tap.Presentation.Financiera

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.tap.Presentation.Financiera.Components.Operaciones
import com.tap.ui.theme.mainBlue
import com.tap.ui.theme.mainOrange
import com.tap.ui.theme.secondaryBlue
import com.tap.ui.theme.tertiaryBlue
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FinancieraScreen(

) {
    val refreshing = remember{ mutableStateOf(true) }
    val swipeRefreshState  = rememberSwipeRefreshState(isRefreshing =refreshing.value)
    LaunchedEffect(key1 = true){
        delay(2000)
        refreshing.value=false
    }
    Scaffold(
        modifier=Modifier.fillMaxWidth()
    ){
        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = {

            },
            indicator = { state, trigger ->
                SwipeRefreshIndicator(
                    state = state,
                    refreshTriggerDistance = trigger,
                    fade = true,
                    contentColor = Color.LightGray,
                    scale = true,
                    backgroundColor = Color.White,
                    shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 100))
                )
            }
        ) {
                Column(
                    modifier=Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                  Column(modifier= Modifier
                      .fillMaxWidth(0.9f)
                      .background(tertiaryBlue, RoundedCornerShape(20.dp)),
                      horizontalAlignment = Alignment.CenterHorizontally
                  ) {
                      Column(
                          modifier=Modifier
                              .fillMaxWidth(0.9f),
                          horizontalAlignment = Alignment.CenterHorizontally
                      ) {
                          Text("Gastos semanales",modifier=Modifier.padding(20.dp), fontWeight = FontWeight.Bold)
                          Row(
                              modifier=Modifier.fillMaxWidth(0.9f)
                          ){
                              Box(modifier= Modifier
                                  .fillMaxWidth(0.8f)
                                  .background(mainBlue)
                                  .height(20.dp)){
                                  Text("")
                              }
                              Box(modifier= Modifier
                                  .fillMaxWidth(0.8f)
                                  .background(mainOrange)
                                  .height(20.dp)){
                                  Text("")
                              }
                          }
                          Spacer(Modifier.padding(top=20.dp))
                          Text("Gasto total: S/. 2300",modifier=Modifier.fillMaxWidth())
                          Text("Gasto promedio semanal: S/. 2450",modifier=Modifier.fillMaxWidth())
                          Spacer(Modifier.padding(10.dp))
                          Text("Ha consumido el 93.87%", fontWeight = FontWeight.Bold,modifier= Modifier
                              .background(
                                  mainBlue, CircleShape
                              )
                              .padding(10.dp),color=Color.White)
                          Spacer(Modifier.padding(10.dp))
                      }
                  }
                    Spacer(modifier = Modifier.padding(10.dp))
                    Card(
                        modifier=Modifier.fillMaxWidth(0.9f),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xffc8e6c9),
                            contentColor = Color.Black
                        )
                    ) {
                        Row(modifier= Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Column {
                                Text("Establecer sobres", fontWeight = FontWeight.Bold)
                                Text("Establece montos para ciertas acciones")
                            }
                            Button(
                                colors=ButtonDefaults.buttonColors(
                                    containerColor = Color(0xff1b5e20),
                                    contentColor = Color.White
                                ),
                                onClick = { /*TODO*/ }) {
                                Text("Agregar")
                            }
                        }
                    }

                    Row(modifier= Modifier
                        .fillMaxWidth(0.9f)
                        .padding(top = 20.dp, bottom = 20.dp)){
                        Text("Mis operaciones", fontWeight = FontWeight.Bold)
                    }
                    LazyColumn(
                        modifier=Modifier.fillMaxWidth(0.9f),
                        contentPadding = PaddingValues(bottom = 100.dp)
                    ){
                        items(10){
                            Operaciones()
                            Spacer(Modifier.padding(10.dp))
                        }
                    }

                }
            }
        }
}