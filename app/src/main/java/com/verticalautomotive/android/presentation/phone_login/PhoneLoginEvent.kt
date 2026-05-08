package com.verticalautomotive.android.presentation.phone_login

sealed interface PhoneLoginEvent {
    data object OnBackClick : PhoneLoginEvent
    data object OnGetCodeClick : PhoneLoginEvent
    data object OnLoginClick : PhoneLoginEvent
    data object OnResendCodeClick : PhoneLoginEvent
}