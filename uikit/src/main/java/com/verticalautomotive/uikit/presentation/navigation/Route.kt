package com.verticalautomotive.uikit.presentation.navigation

sealed class Route(val route: String) {
    data object Home : Route("home")
    data object Services : Route("services")
    data object Garage : Route("garage")
    data object Chat : Route("chat")
}