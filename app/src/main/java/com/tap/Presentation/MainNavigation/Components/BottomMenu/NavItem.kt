package com.tap.Presentation.MainNavigation.Components.BottomMenu

import com.tap.R

sealed class NavItem(
    val route : String,
    val title : String,
    val icon : Int
) {
    object Vida: NavItem(
        route="vida",
        title = "Vida",
        icon= R.drawable.vidamenu
    )
    object Financiero: NavItem(
        route="financiero",
        title = "Financiero",
        icon=  R.drawable.financieromenu
    )
    object Perfil: NavItem(
        route="perfil",
        title = "perfil",
        icon= R.drawable.user
    )
}