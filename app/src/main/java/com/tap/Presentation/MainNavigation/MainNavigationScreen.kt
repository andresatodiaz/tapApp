package com.tap.Presentation.MainNavigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tap.Presentation.MainNavigation.Components.BottomMenu.BottomMenu
import com.tap.Presentation.MainNavigation.Components.TopMenu

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainNavigationScreen(
    navController : NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = {
                 TopMenu()
        },
        bottomBar = {
            BottomMenu(navController = navController)
        }
    ) {
        Column(
            modifier= Modifier.fillMaxHeight()
                .fillMaxWidth()
                .padding(top=80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            MainNavigationGraph(
                navController
            )
        }

    }
}