package com.verticalautomotive.android.presentation.phone_login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.verticalautomotive.android.common.util.FormatUtil
import com.verticalautomotive.uikit.presentation.components.inputs.OtpCodeInput
import com.verticalautomotive.uikit.common.theme.VerticalTheme
import com.verticalautomotive.uikit.presentation.components.buttons.VerticalButton
import com.verticalautomotive.uikit.presentation.components.buttons.VerticalTextButton
import com.verticalautomotive.uikit.presentation.components.toolbar.Toolbar

@Composable
fun PhoneConfirmationRoot(
    viewModel: PhoneLoginViewModel,
    onBackClick: () -> Unit,
    onLoginClick: () -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    PhoneConfirmationScreen(
        state = state,
        onEvent = { event ->
            when (event) {
                PhoneLoginEvent.OnBackClick -> onBackClick()
                PhoneLoginEvent.OnLoginClick -> onLoginClick()
                else -> Unit
            }
            viewModel.onEvent(event)
        }
    )
}

@Composable
fun PhoneConfirmationScreen(
    state: PhoneLoginState,
    onEvent: (PhoneLoginEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            Toolbar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                onBackClick = {
                    onEvent(PhoneLoginEvent.OnBackClick)
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .padding(top = 56.dp, bottom = 40.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Confirmation of phone number",
                    style = VerticalTheme.typography.h1
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = buildAnnotatedString {
                        append("The code was sent to ")
                        withStyle(
                            style = SpanStyle(
                                color = VerticalTheme.colorScheme.linkText
                            )
                        ) {
                            append(
                                text = FormatUtil.formatPhoneNumber(
                                    phoneNumber = state.phoneNumberState.text.toString()
                                )
                            )
                        }
                    },
                    style = VerticalTheme.typography.mainText,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OtpCodeInput(
                        modifier = Modifier.fillMaxWidth(),
                        state = state.confirmationCodeState,
                        isOtpCodeValid = state.isConfirmationCodeValid
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Send the code again in ${FormatUtil.formatDuration(state.resendCountdownSeconds)}",
                        style = VerticalTheme.typography.mainText,
                        textAlign = TextAlign.Center
                    )
                    VerticalTextButton(
                        modifier = Modifier.fillMaxWidth(),
                        label = "Resend Code",
                        onClick = {
                            onEvent(PhoneLoginEvent.OnResendCodeClick)
                        },
                        enabled = state.resendCountdownSeconds == 0
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            VerticalButton(
                modifier = Modifier.fillMaxWidth(),
                label = "Log In",
                onClick = {
                    onEvent(PhoneLoginEvent.OnLoginClick)
                },
                enabled = state.isConfirmationCodeValid
            )
        }
    }
}