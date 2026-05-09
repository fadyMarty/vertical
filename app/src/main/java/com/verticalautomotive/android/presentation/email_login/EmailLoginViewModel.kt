package com.verticalautomotive.android.presentation.email_login

import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.verticalautomotive.android.domain.use_case.ValidateEmailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

class EmailLoginViewModel(
    private val validateEmailUseCase: ValidateEmailUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(EmailLoginState())
    val state = _state.asStateFlow()

    private val isEmailValidFlow = snapshotFlow {
        _state.value.emailState.text.toString()
    }.map { email ->
        validateEmailUseCase(email)
    }.distinctUntilChanged()

    private val isPasswordNotBlankFlow = snapshotFlow {
        _state.value.passwordState.text.toString()
    }.map { password ->
        password.isNotBlank()
    }.distinctUntilChanged()

    init {
        observeValidationStates()
    }

    fun onEvent(event: EmailLoginEvent) {
        when (event) {
            EmailLoginEvent.OnTogglePasswordVisibility -> {
                _state.update {
                    it.copy(
                        isPasswordVisible = !it.isPasswordVisible
                    )
                }
            }
            else -> Unit
        }
    }

    private fun observeValidationStates() {
        combine(
            isEmailValidFlow,
            isPasswordNotBlankFlow
        ) { isEmailValid, isPasswordNotBlank ->
            _state.update {
                it.copy(
                    canLogin = isEmailValid && isPasswordNotBlank
                )
            }
        }.launchIn(viewModelScope)
    }
}