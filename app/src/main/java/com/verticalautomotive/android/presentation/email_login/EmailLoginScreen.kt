package com.verticalautomotive.android.presentation.email_login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.verticalautomotive.uikit.common.theme.VerticalTheme
import com.verticalautomotive.uikit.presentation.components.buttons.VerticalButton
import com.verticalautomotive.uikit.presentation.components.inputs.Input
import com.verticalautomotive.uikit.presentation.components.inputs.PasswordInput
import com.verticalautomotive.uikit.presentation.components.toolbar.Toolbar
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun EmailLoginRoot(
    viewModel: EmailLoginViewModel = koinViewModel(),
    onBackClick: () -> Unit,
    onLoginClick: () -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    EmailLoginScreen(
        state = state,
        onEvent = { event ->
            when (event) {
                EmailLoginEvent.OnBackClick -> onBackClick()
                EmailLoginEvent.OnLoginClick -> onLoginClick()
                else -> Unit
            }
            viewModel.onEvent(event)
        }
    )
}

@Composable
fun EmailLoginScreen(
    state: EmailLoginState,
    onEvent: (EmailLoginEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            Toolbar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                onBackClick = {
                    onEvent(EmailLoginEvent.OnBackClick)
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
                    text = "Welcome Back!",
                    style = VerticalTheme.typography.h1
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    Input(
                        state = state.emailState,
                        label = "E-mail"
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        PasswordInput(
                            state = state.passwordState,
                            isPasswordVisible = state.isPasswordVisible,
                            onToggleVisibilityClick = {
                                onEvent(EmailLoginEvent.OnTogglePasswordVisibility)
                            }
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Forgot your password?",
                            style = VerticalTheme.typography.signature,
                            color = VerticalTheme.colorScheme.linkText
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            VerticalButton(
                modifier = Modifier.fillMaxWidth(),
                label = "Log in",
                onClick = {
                    onEvent(EmailLoginEvent.OnLoginClick)
                },
                enabled = state.canLogin
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun EmailLoginScreenPreview() {
    VerticalTheme {
        EmailLoginScreen(
            state = EmailLoginState(),
            onEvent = {}
        )
    }
}