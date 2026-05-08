package com.verticalautomotive.android.presentation.welcome

sealed interface WelcomeEvent {
    data object OnPhoneNumberLoginClick : WelcomeEvent
    data object OnEmailLoginClick : WelcomeEvent
}