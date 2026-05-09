package com.verticalautomotive.android.presentation.phone_login

import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PhoneLoginViewModel : ViewModel() {

    private val _state = MutableStateFlow(PhoneLoginState())
    val state = _state.asStateFlow()

    private val eventChannel = Channel<PhoneLoginEvent>()
    val events = eventChannel.receiveAsFlow()

    private var resendTimerJob: Job? = null

    private val isPhoneNumberValidFlow = snapshotFlow {
        state.value.phoneNumberState.text.toString()
    }.map { phoneNumber ->
        phoneNumber.length == 11
    }.distinctUntilChanged()

    private val isConfirmationCodeValid = snapshotFlow {
        state.value.confirmationCodeState.text.toString()
    }.map { confirmationCode ->
        confirmationCode.length == 6
    }.distinctUntilChanged()

    init {
        observeValidationStates()
    }

    fun onEvent(event: PhoneLoginEvent) {
        when (event) {
            PhoneLoginEvent.OnGetCodeClick -> {
                viewModelScope.launch {
                    getCode()
                    eventChannel.send(PhoneLoginEvent.OnGetCodeClick)
                }
            }
            PhoneLoginEvent.OnResendCodeClick -> {
                getCode()
            }
            else -> Unit
        }
    }

    private fun observeValidationStates() {
        combine(
            isPhoneNumberValidFlow,
            isConfirmationCodeValid,
        ) { isPhoneNumberValid, isConfirmationCodeValid ->
            _state.update {
                it.copy(
                    isPhoneNumberValid = isPhoneNumberValid,
                    isConfirmationCodeValid = isConfirmationCodeValid
                )
            }
        }.launchIn(viewModelScope)
    }

    private fun getCode() {
        resendTimerJob?.cancel()
        resendTimerJob = viewModelScope.launch {
            _state.update {
                it.copy(
                    resendCountdownSeconds = 239
                )
            }
            while (state.value.resendCountdownSeconds > 0) {
                delay(1000L)
                _state.update {
                    it.copy(
                        resendCountdownSeconds = it.resendCountdownSeconds - 1
                    )
                }
            }
        }
    }
}