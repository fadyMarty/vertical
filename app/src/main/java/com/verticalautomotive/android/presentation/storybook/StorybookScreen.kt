package com.verticalautomotive.android.presentation.storybook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.verticalautomotive.uikit.R
import com.verticalautomotive.uikit.presentation.components.buttons.VerticalButton
import com.verticalautomotive.uikit.presentation.components.buttons.VerticalIconButton
import com.verticalautomotive.uikit.presentation.components.buttons.VerticalTextButton
import com.verticalautomotive.uikit.presentation.components.indicators.StatusBar
import com.verticalautomotive.uikit.presentation.components.inputs.Input
import com.verticalautomotive.uikit.presentation.components.inputs.PasswordInput
import com.verticalautomotive.uikit.presentation.components.inputs.transformations.PhoneNumberInputTransformation
import com.verticalautomotive.uikit.presentation.components.inputs.transformations.PhoneNumberOutputTransformation

@Composable
fun StorybookScreen() {
    Scaffold(
        contentWindowInsets = WindowInsets.safeDrawing
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                StatusBar(
                    pageCount = 4,
                    currentPage = 2
                )
            }
            item {
                VerticalTextButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Resend Code",
                    onClick = {},
                    enabled = false
                )
            }
            item {
                VerticalTextButton(
                    label = "Skip",
                    onClick = {},
                    textAlign = TextAlign.Start
                )
            }
            item {
                VerticalButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Next",
                    onClick = {}
                )
            }
            item {
                VerticalButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Get the code",
                    onClick = {},
                    enabled = false
                )
            }
            item {
                VerticalButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Add a car",
                    onClick = {},
                    trailingIcon = ImageVector.vectorResource(R.drawable.ic_add)
                )
            }
            item {
                VerticalIconButton(
                    icon = ImageVector.vectorResource(R.drawable.ic_paperclip),
                    onClick = {}
                )
            }
            item {
                Input(
                    state = rememberTextFieldState("1"),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
                    ),
                    inputTransformation = PhoneNumberInputTransformation(),
                    outputTransformation = PhoneNumberOutputTransformation()
                )
            }
            item {
                Input(
                    state = rememberTextFieldState("15551234567"),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
                    ),
                    inputTransformation = PhoneNumberInputTransformation(),
                    outputTransformation = PhoneNumberOutputTransformation()
                )
            }
            item {
                Input(
                    state = rememberTextFieldState()
                )
            }
            item {
                Input(
                    state = rememberTextFieldState("username@gmail.com")
                )
            }
            item {
                PasswordInput(
                    state = rememberTextFieldState("MDWI#*R*@!! RR"),
                    isPasswordVisible = true,
                    onToggleVisibilityClick = {}
                )
            }
            item {
                PasswordInput(
                    state = rememberTextFieldState("MDWI#*R*@!! RR"),
                    isPasswordVisible = false,
                    onToggleVisibilityClick = {}
                )
            }
        }
    }
}