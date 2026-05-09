package com.verticalautomotive.android.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.verticalautomotive.android.R
import com.verticalautomotive.android.presentation.welcome.components.LoginButton
import com.verticalautomotive.uikit.common.theme.VerticalTheme
import com.verticalautomotive.uikit.presentation.components.buttons.VerticalButton
import com.verticalautomotive.uikit.presentation.components.buttons.VerticalTextButton

@Composable
fun WelcomeRoot(
    onPhoneNumberLoginClick: () -> Unit,
    onEmailLoginClick: () -> Unit,
) {
    WelcomeScreen(
        onEvent = { event ->
            when (event) {
                WelcomeEvent.OnPhoneNumberLoginClick -> onPhoneNumberLoginClick()
                WelcomeEvent.OnEmailLoginClick -> onEmailLoginClick()
            }
        }
    )
}

@Composable
fun WelcomeScreen(
    onEvent: (WelcomeEvent) -> Unit,
) {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(R.drawable.img_welcome),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(innerPadding)
                    .padding(bottom = 49.dp),
                verticalArrangement = Arrangement.spacedBy(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome",
                    style = VerticalTheme.typography.h1,
                    textAlign = TextAlign.Center
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    VerticalButton(
                        modifier = Modifier.fillMaxWidth(),
                        label = "Log in with your phone number",
                        onClick = {
                            onEvent(WelcomeEvent.OnPhoneNumberLoginClick)
                        }
                    )
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = VerticalTheme.colorScheme.strokeGrey
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "or",
                            style = VerticalTheme.typography.mainText,
                            textAlign = TextAlign.Center
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                space = 16.dp,
                                alignment = Alignment.CenterHorizontally
                            )
                        ) {
                            LoginButton(
                                icon = ImageVector.vectorResource(R.drawable.ic_google),
                                onClick = {}
                            )
                            LoginButton(
                                icon = ImageVector.vectorResource(R.drawable.ic_vk),
                                onClick = {}
                            )
                            LoginButton(
                                icon = ImageVector.vectorResource(R.drawable.ic_apple),
                                onClick = {}
                            )
                            LoginButton(
                                icon = ImageVector.vectorResource(R.drawable.ic_facebook),
                                onClick = {}
                            )
                            LoginButton(
                                icon = ImageVector.vectorResource(R.drawable.ic_mail),
                                onClick = {
                                    onEvent(WelcomeEvent.OnEmailLoginClick)
                                }
                            )
                        }
                    }
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = VerticalTheme.colorScheme.strokeGrey
                    )
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = ImageVector.vectorResource(R.drawable.ic_face_id),
                        contentDescription = null
                    )
                    VerticalTextButton(
                        label = "Sign Up",
                        onClick = {}
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun WelcomeScreenPreview() {
    VerticalTheme {
        WelcomeScreen(
            onEvent = {}
        )
    }
}