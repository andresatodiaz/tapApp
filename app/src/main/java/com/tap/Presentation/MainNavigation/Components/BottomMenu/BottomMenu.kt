package com.tap.Presentation.MainNavigation.Components.BottomMenu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.tap.ui.theme.backgroundBlue
import com.tap.ui.theme.mainBlue

@Composable
fun BottomMenu (
    navController:NavController
){
    val item = listOf(
        NavItem.Vida,
        NavItem.Financiero,
        NavItem.Perfil,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp),
        containerColor = mainBlue
    ) {
        Row(
            modifier= Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            item.forEach {
                    item->
                Column(modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .clickable {
                        navController.navigate(item.route)
                    },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier=Modifier
                            .background(if(item.route==currentRoute) backgroundBlue else Color.Transparent,
                                CircleShape)
                            .padding(top=5.dp, bottom = 5.dp,end=10.dp, start = 10.dp)


                    ){
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = "icon",
                            modifier= Modifier.size(25.dp),
                            tint=Color.White
                        )
                    }
                    Text(
                        text=item.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color=Color.White,
                        modifier = Modifier.padding(top=5.dp)
                    )
                }
            }
        }

    }
}