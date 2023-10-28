package com.tap.Presentation.Home

import android.Manifest
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.tap.Data.Entities.Cobro
import com.tap.Data.Entities.Service
import com.tap.Presentation.Home.Components.Account.AccountCarrousel
import com.tap.Presentation.Home.Components.Services.CobroCarrousel
import com.tap.Presentation.Home.Components.Services.ServicesCarrousel
import com.tap.Presentation.Notification.Notification
import com.tap.R
import com.tap.ui.theme.mainBlue
import com.tap.ui.theme.mainOrange
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalPermissionsApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {
    val refreshing = remember{ mutableStateOf(true) }
    val coroutine = rememberCoroutineScope()

    LaunchedEffect(key1 = true){
        delay(2000)
        refreshing.value=false
    }

    val swipeRefreshState  = rememberSwipeRefreshState(isRefreshing =refreshing.value)

    val postNotificationPermission=
        rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)
    LaunchedEffect(key1 = true ){
        if(!postNotificationPermission.status.isGranted){
            postNotificationPermission.launchPermissionRequest()
        }
    }

    Scaffold(
        modifier=Modifier.fillMaxWidth(),

        floatingActionButton = {
            Button(
                colors=ButtonDefaults.buttonColors(
                    containerColor = mainOrange
                ),
                modifier=Modifier.padding(bottom=80.dp),
                onClick = {
                navController.navigate("qr")
            }) {
                Text("Servicio por QR",modifier=Modifier.padding(10.dp))
                Icon(painter = painterResource(id = R.drawable.qricon), contentDescription = "qr")
            }
        },

    ){
        Column(
            modifier=Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier=Modifier.fillMaxWidth(0.9f)
            ){
                SwipeRefresh(
                    state = swipeRefreshState,
                    onRefresh = {
                        coroutine.launch {
                            refreshing.value=true
                            delay(2000)
                            refreshing.value=false
                        }
                    },
                    indicator = { state, trigger ->
                        SwipeRefreshIndicator(
                            state = state,
                            refreshTriggerDistance = trigger,
                            fade = true,
                            contentColor = mainBlue,
                            scale = true,
                            backgroundColor = Color.White,
                            shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 100))
                        )
                    }
                ) {
                    LazyColumn(
                        contentPadding = PaddingValues(bottom=100.dp)
                    ){
                        item{
                            AccountCarrousel()
                        }
                        item{
                            ServicesCarrousel(section = "Mis servicios básicos",
                                servicesList = listOf(Service("Luz del Sur",153.30,"Pendiente","28/09"), Service("Entel",39.90,"Pagado","27/10"), Service("Sedapal",101.90,"Próximo","30/10"), ),
                                navController = navController
                            )
                        }
                        item{
                            ServicesCarrousel(section = "Pagos a terceros",
                                servicesList = listOf(Service("Alquiler",1500.00,"Pendiente","29/09"), Service("Jardinero",12.00,"Pagado","26/10"), Service("Niñera",1200.00,"Próximo","31/10") ),
                                navController = navController
                            )
                        }
                        item{
                            CobroCarrousel(cobroList = listOf(Cobro("Pasear perro",20.0,"29/10",true),Cobro("Limpiar techo",120.0,"29/10",true))
                                , navController =navController )
                        }
                        item{
                            ServicesCarrousel(section = "Transporte",
                                servicesList = listOf(Service("PECS",78.00,codigo="87823487"), Service("Línea 1",12.50,codigo="98876823")  ),
                                navController = navController
                            )
                        }
                        item{
                            ServicesCarrousel(section = "Tarjeta de crédito",
                                servicesList = listOf(Service("**** 2384",1500.00,"Pendiente","29/09") ),
                                navController = navController
                            )
                        }
                    }
                }

            }
        }

    }



}