package com.verticalautomotive.android.presentation.email_login

import androidx.compose.foundation.text.input.TextFieldState

data class EmailLoginState(
    val emailState: TextFieldState = TextFieldState(),
    val passwordState: TextFieldState = TextFieldState(),
    val isPasswordVisible: Boolean = false,
    val canLogin: Boolean = false,
)
