package com.verticalautomotive.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.verticalautomotive.android.presentation.onboarding.OnboardingRoot

@Composable
fun NavigationRoot() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.Onboarding
    ) {
        composable<Route.Onboarding> {
            OnboardingRoot(
                onSkipClick = {
                    navController.navigate(Route.AuthGraph) {
                        popUpTo(Route.Onboarding) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        authGraph(navController = navController)
        composable<Route.HomeGraph> {
            HomeGraph()
        }
    }
}