package com.verticalautomotive.android.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.verticalautomotive.android.presentation.email_login.EmailLoginRoot
import com.verticalautomotive.android.presentation.phone_login.PhoneConfirmationRoot
import com.verticalautomotive.android.presentation.phone_login.PhoneLoginRoot
import com.verticalautomotive.android.presentation.welcome.WelcomeRoot
import org.koin.compose.viewmodel.sharedKoinViewModel

fun NavGraphBuilder.authGraph(
    navController: NavHostController,
) {
    navigation(
        route = Route.AuthGraph.route,
        startDestination = Route.Welcome.route
    ) {
        composable(
            route = Route.Welcome.route
        ) {
            WelcomeRoot(
                onPhoneNumberLoginClick = {
                    navController.navigate(Route.PhoneLoginGraph.route)
                },
                onEmailLoginClick = {
                    navController.navigate(Route.EmailLogin.route)
                }
            )
        }
        navigation(
            route = Route.PhoneLoginGraph.route,
            startDestination = Route.PhoneLogin.route
        ) {
            composable(
                route = Route.PhoneLogin.route
            ) {
                PhoneLoginRoot(
                    viewModel = it.sharedKoinViewModel(navController),
                    onBackClick = {
                        navController.navigateUp()
                    },
                    onGetCodeClick = {
                        navController.navigate(Route.PhoneConfirmation.route)
                    }
                )
            }
            composable(
                route = Route.PhoneConfirmation.route
            ) {
                PhoneConfirmationRoot(
                    viewModel = it.sharedKoinViewModel(navController),
                    onBackClick = {
                        navController.navigateUp()
                    },
                    onLoginClick = {
                        navController.navigate(Route.HomeGraph.route) {
                            popUpTo(Route.AuthGraph.route) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }
        composable(
            route = Route.EmailLogin.route
        ) {
            EmailLoginRoot(
                onBackClick = {
                    navController.navigateUp()
                },
                onLoginClick = {
                    navController.navigate(Route.HomeGraph.route) {
                        popUpTo(Route.AuthGraph.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}