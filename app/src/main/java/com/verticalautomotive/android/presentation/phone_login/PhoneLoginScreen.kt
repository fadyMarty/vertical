package com.verticalautomotive.android.presentation.phone_login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.verticalautomotive.android.common.util.ObserveAsEvents
import com.verticalautomotive.uikit.common.theme.VerticalTheme
import com.verticalautomotive.uikit.presentation.components.buttons.VerticalButton
import com.verticalautomotive.uikit.presentation.components.inputs.Input
import com.verticalautomotive.uikit.presentation.components.inputs.transformations.PhoneNumberInputTransformation
import com.verticalautomotive.uikit.presentation.components.inputs.transformations.PhoneNumberOutputTransformation
import com.verticalautomotive.uikit.presentation.components.toolbar.Toolbar

@Composable
fun PhoneLoginRoot(
    viewModel: PhoneLoginViewModel,
    onBackClick: () -> Unit,
    onGetCodeClick: () -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ObserveAsEvents(viewModel.events) { event ->
        when (event) {
            PhoneLoginEvent.OnGetCodeClick -> onGetCodeClick()
            else -> Unit
        }
    }

    PhoneLoginScreen(
        state = state,
        onEvent = { event ->
            when (event) {
                PhoneLoginEvent.OnBackClick -> onBackClick()
                else -> Unit
            }
            viewModel.onEvent(event)
        }
    )
}

@Composable
fun PhoneLoginScreen(
    state: PhoneLoginState,
    onEvent: (PhoneLoginEvent) -> Unit,
) {
    Scaffold(
        contentWindowInsets = WindowInsets.systemBars
            .union(WindowInsets.displayCutout)
            .add(WindowInsets(bottom = 40.dp))
            .union(
                WindowInsets.ime.add(
                    WindowInsets(bottom = 33.dp)
                )
            ),
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
                .padding(top = 56.dp)
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
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Input(
                        state = state.phoneNumberState,
                        label = "Phone number:",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone
                        ),
                        inputTransformation = PhoneNumberInputTransformation(),
                        outputTransformation = PhoneNumberOutputTransformation()
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(117.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                VerticalButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Get the code",
                    onClick = {
                        onEvent(PhoneLoginEvent.OnGetCodeClick)
                    },
                    enabled = state.isPhoneNumberValid
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    text = buildAnnotatedString {
                        append("By continuing, you agree to our ")
                        withLink(
                            LinkAnnotation.Clickable(
                                tag = "PRIVACY_POLICY",
                                styles = TextLinkStyles(
                                    style = SpanStyle(
                                        color = VerticalTheme.colorScheme.linkText
                                    )
                                )
                            ) {}
                        ) {
                            append("Privacy Policy")
                        }
                        append(" and ")
                        withLink(
                            LinkAnnotation.Clickable(
                                tag = "TERMS_AND_CONDITIONS",
                                styles = TextLinkStyles(
                                    style = SpanStyle(
                                        color = VerticalTheme.colorScheme.linkText
                                    )
                                )
                            ) {}
                        ) {
                            append("Terms and Conditions")
                        }
                        append(".")
                    },
                    style = VerticalTheme.typography.mainText,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PhoneLoginScreenPreview() {
    VerticalTheme {
        PhoneLoginScreen(
            state = PhoneLoginState(),
            onEvent = {}
        )
    }
}