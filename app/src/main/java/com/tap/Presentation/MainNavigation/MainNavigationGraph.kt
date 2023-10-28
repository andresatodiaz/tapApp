package com.tap.Presentation.MainNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tap.Presentation.Agregar.Generico.GenericoScreen
import com.tap.Presentation.Agregar.PagoTerceros.PagoTercerosScreen
import com.tap.Presentation.Home.HomeScreen
import com.tap.Presentation.Perfil.PerfilScreen

@Composable
fun MainNavigationGraph (
    navController: NavHostController
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
    }

}