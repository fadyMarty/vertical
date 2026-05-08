package com.verticalautomotive.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.verticalautomotive.android.presentation.phone_login.PhoneConfirmationRoot
import com.verticalautomotive.android.presentation.phone_login.PhoneLoginRoot
import com.verticalautomotive.android.presentation.welcome.WelcomeRoot
import org.koin.compose.viewmodel.sharedKoinViewModel

@Composable
fun NavigationRoot() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.AuthGraph
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
                            navController.navigate(Route.MainGraph) {
                                popUpTo(Route.AuthGraph)
                            }
                        }
                    )
                }
            }
            composable<Route.EmailLogin> {

            }
        }
        navigation<Route.MainGraph>(
            startDestination = Route.Home
        ) {
            composable<Route.Home> {

            }
        }
    }
}