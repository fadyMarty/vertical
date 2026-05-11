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
import com.verticalautomotive.android.domain.model.Chat
import com.verticalautomotive.android.presentation.chat_list.ChatListRoot
import com.verticalautomotive.android.presentation.home.HomeRoot
import com.verticalautomotive.uikit.R
import com.verticalautomotive.uikit.presentation.components.bottom_bar.BottomBar
import com.verticalautomotive.uikit.presentation.components.bottom_bar.BottomBarItem

@Composable
fun HomeGraph(
    onChatClick: (Chat) -> Unit,
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
                        selected = currentDestination.isSelected(
                            route = Route.Home.route
                        ),
                        icon = R.drawable.ic_home,
                        label = "Home",
                        route = Route.Home.route
                    ),
                    BottomBarItem(
                        selected = currentDestination.isSelected(
                            route = Route.Services.route
                        ),
                        icon = R.drawable.ic_3dcube,
                        label = "Services",
                        route = Route.Services.route
                    ),
                    BottomBarItem(
                        selected = currentDestination.isSelected(
                            route = Route.Garage.route
                        ),
                        icon = R.drawable.ic_car,
                        label = "Garage",
                        route = Route.Garage.route
                    ),
                    BottomBarItem(
                        selected = currentDestination.isSelected(
                            route = Route.Chat.route
                        ),
                        icon = R.drawable.ic_message,
                        label = "Chat",
                        route = Route.Chat.route
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
            startDestination = Route.Home.route
        ) {
            composable(
                route = Route.Home.route
            ) {
                HomeRoot()
            }
            composable(
                route = Route.Services.route
            ) {

            }
            composable(
                route = Route.Garage.route
            ) {

            }
            composable(
                route = Route.Chat.route
            ) {
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

private fun NavDestination?.isSelected(
    route: String,
): Boolean {
    return this?.hierarchy?.any {
        it.route == route
    } == true
}