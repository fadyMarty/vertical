package com.verticalautomotive.android.presentation.email_login

sealed interface EmailLoginEvent {
    data object OnBackClick : EmailLoginEvent
    data object OnTogglePasswordVisibility : EmailLoginEvent
    data object OnLoginClick : EmailLoginEvent
}