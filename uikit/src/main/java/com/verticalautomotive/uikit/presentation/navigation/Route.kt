package com.verticalautomotive.uikit.presentation.navigation

internal sealed interface Route {
    data object Home : Route
    data object Services : Route
    data object Garage : Route
    data object Chat : Route
}