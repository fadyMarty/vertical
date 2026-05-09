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
    navigation<Route.AuthGraph>(
        startDestination = Route.Welcome
    ) {
        composable<Route.Welcome> {
            WelcomeRoot(
                onPhoneNumberLoginClick = {
                    navController.navigate(Route.PhoneLoginGraph)
                },
                onEmailLoginClick = {
                    navController.navigate(Route.EmailLogin)
                }
            )
        }
        navigation<Route.PhoneLoginGraph>(
            startDestination = Route.PhoneLogin
        ) {
            composable<Route.PhoneLogin> {
                PhoneLoginRoot(
                    viewModel = it.sharedKoinViewModel(navController),
                    onBackClick = {
                        navController.navigateUp()
                    },
                    onGetCodeClick = {
                        navController.navigate(Route.PhoneConfirmation)
                    }
                )
            }
            composable<Route.PhoneConfirmation> {
                PhoneConfirmationRoot(
                    viewModel = it.sharedKoinViewModel(navController),
                    onBackClick = {
                        navController.navigateUp()
                    },
                    onLoginClick = {
                        navController.navigate(Route.HomeGraph) {
                            popUpTo(Route.AuthGraph) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }
        composable<Route.EmailLogin> {
            EmailLoginRoot(
                onBackClick = {
                    navController.navigateUp()
                },
                onLoginClick = {
                    navController.navigate(Route.HomeGraph) {
                        popUpTo(Route.AuthGraph) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}