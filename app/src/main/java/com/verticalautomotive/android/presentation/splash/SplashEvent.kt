package com.verticalautomotive.android.presentation.splash

sealed interface SplashEvent {
    data class OnReadOnboardingState(val route: String) : SplashEvent
}