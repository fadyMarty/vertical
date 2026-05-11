package com.verticalautomotive.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.verticalautomotive.android.presentation.chat_detail.ChatDetailRoot
import com.verticalautomotive.android.presentation.onboarding.OnboardingRoot
import com.verticalautomotive.android.presentation.splash.SplashRoot

@Composable
fun NavigationRoot() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.Splash.route
    ) {
        composable(
            route = Route.Splash.route
        ) {
            SplashRoot(
                onReadOnboardingState = { route ->
                    navController.navigate(route) {
                        popUpTo(Route.Splash.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(
            route = Route.Onboarding.route
        ) {
            OnboardingRoot(
                onSkipClick = {
                    navController.navigate(Route.AuthGraph.route) {
                        popUpTo(Route.Onboarding.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        authGraph(navController = navController)
        composable(
            route = Route.HomeGraph.route
        ) {
            HomeGraph(
                onChatClick = { chat ->
                    navController.navigate(Route.ChatDetail.route + "/${chat.id}")
                }
            )
        }
        composable(
            route = Route.ChatDetail.route + "/{chatId}",
            arguments = listOf(
                navArgument(
                    name = "chatId",
                ) {
                    type = NavType.IntType
                }
            )
        ) {
            ChatDetailRoot()
        }
    }
}