package com.verticalautomotive.android.presentation.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.verticalautomotive.android.presentation.chat_list.ChatListRoot
import com.verticalautomotive.android.presentation.home.HomeRoot
import com.verticalautomotive.uikit.R
import com.verticalautomotive.uikit.presentation.components.bottom_bar.BottomBar
import com.verticalautomotive.uikit.presentation.components.bottom_bar.BottomBarItem

@Composable
fun HomeGraph(
    onChatClick: (Int) -> Unit,
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars,
        bottomBar = {
            BottomBar(
                items = listOf(
                    BottomBarItem(
                        selected = isRouteSelected(
                            route = Route.Home,
                            currentDestination = currentDestination
                        ),
                        icon = R.drawable.ic_home,
                        label = "Home",
                        route = Route.Home
                    ),
                    BottomBarItem(
                        selected = isRouteSelected(
                            route = Route.Services,
                            currentDestination = currentDestination
                        ),
                        icon = R.drawable.ic_3dcube,
                        label = "Services",
                        route = Route.Services
                    ),
                    BottomBarItem(
                        selected = isRouteSelected(
                            route = Route.Garage,
                            currentDestination = currentDestination
                        ),
                        icon = R.drawable.ic_car,
                        label = "Garage",
                        route = Route.Garage
                    ),
                    BottomBarItem(
                        selected = isRouteSelected(
                            route = Route.Chat,
                            currentDestination = currentDestination
                        ),
                        icon = R.drawable.ic_message,
                        label = "Chat",
                        route = Route.Chat
                    )
                ),
                onItemClick = { item ->
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = Route.Home
        ) {
            composable<Route.Home> {
                HomeRoot()
            }
            composable<Route.Services> {

            }
            composable<Route.Garage> {

            }
            composable<Route.Chat> {
                ChatListRoot(
                    onBackClick = {
                        navController.navigateUp()
                    },
                    onChatClick = onChatClick
                )
            }
        }
    }
}

private fun isRouteSelected(
    route: Route,
    currentDestination: NavDestination?,
): Boolean {
    return currentDestination?.hierarchy?.any {
        it.route == route::class.qualifiedName
    } == true
}