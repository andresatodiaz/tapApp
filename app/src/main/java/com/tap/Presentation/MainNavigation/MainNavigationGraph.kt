package com.tap.Presentation.MainNavigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ecommmerceapp.presentation.QrScanner.QrScannerScreen
import com.example.ecommmerceapp.presentation.QrScanner.ViewModel.QrScannerViewModel
import com.tap.Presentation.Agregar.Generico.GenericoScreen
import com.tap.Presentation.Agregar.PagoTerceros.PagoTercerosScreen
import com.tap.Presentation.Financiera.FinancieraScreen
import com.tap.Presentation.Home.HomeScreen
import com.tap.Presentation.PagoExitoso.PagoExitoso
import com.tap.Presentation.Perfil.PerfilScreen
import com.tap.Presentation.ServiceInfo.ServiceScreen
import com.tap.Presentation.Sobres.SobreScreen

@Composable
fun MainNavigationGraph (
    navController: NavHostController,
    qrScannerViewModel: QrScannerViewModel= hiltViewModel()
){
    NavHost(
        navController = navController,
        startDestination = "vida",

        ) {
        composable("vida"){
            HomeScreen(
                navController
            )
        }
        composable("agregarGenerico"){
            GenericoScreen()
        }
        composable("agregarPagoTerceros"){
            PagoTercerosScreen()
        }
        composable("perfil"){
            PerfilScreen()
        }
        composable("qr"){
            QrScannerScreen(navController = navController, qrScannerViewModel =qrScannerViewModel )
        }
        composable("financiero"){
            FinancieraScreen(navController)
        }
        composable("serviceScreen/{nombre}/{precio}/{fecha}/{operaciones}", arguments =
            listOf(
                navArgument("nombre"){
                    type= NavType.StringType
                },
                navArgument("precio"){
                    type= NavType.StringType
                },
                navArgument("fecha"){
                    type= NavType.StringType
                },
                navArgument("operaciones"){
                    type= NavType.StringType
                }
            )
        ){

            val nombre = it.arguments!!.getString("nombre")!!
            val precio = it.arguments!!.getString("precio")!!
            val fecha = it.arguments!!.getString("fecha")!!
            val operaciones = it.arguments!!.getString("operaciones")!!
            BackHandler {
                navController.navigate("vida")
            }
            ServiceScreen(nombre = nombre, precio = precio, fecha = fecha, operaciones = operaciones,navController)
        }
        composable("pagoExitoso/{destino}", arguments = listOf(
            navArgument("destino"){
                type= NavType.StringType
            }
        )){
            val destino = it.arguments!!.getString("destino")!!
            PagoExitoso(navController,destino)
        }
        composable("sobreScreen"){
            SobreScreen()
        }
    }

}