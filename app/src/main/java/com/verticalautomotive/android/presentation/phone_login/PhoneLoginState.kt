package com.verticalautomotive.android.presentation.phone_login

import androidx.compose.foundation.text.input.TextFieldState

data class PhoneLoginState(
    val phoneNumberState: TextFieldState = TextFieldState("1"),
    val isPhoneNumberValid: Boolean = false,
    val confirmationCodeState: TextFieldState = TextFieldState(),
    val isConfirmationCodeValid: Boolean = false,
    val resendCountdownSeconds: Int = 239,
)
