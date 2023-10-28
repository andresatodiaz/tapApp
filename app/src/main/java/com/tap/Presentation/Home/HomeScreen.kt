package com.tap.Presentation.Home

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.tap.Data.Entities.Cobro
import com.tap.Data.Entities.Service
import com.tap.Presentation.Home.Components.Account.AccountCarrousel
import com.tap.Presentation.Home.Components.Services.CobroCarrousel
import com.tap.Presentation.Home.Components.Services.ServicesCarrousel
import com.tap.Presentation.Notification.Notification

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HomeScreen(
    navController: NavController
) {

    val postNotificationPermission=
        rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)
    LaunchedEffect(key1 = true ){
        if(!postNotificationPermission.status.isGranted){
            postNotificationPermission.launchPermissionRequest()
        }
    }

    Column(
        modifier=Modifier.fillMaxWidth(0.9f)
    ){
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