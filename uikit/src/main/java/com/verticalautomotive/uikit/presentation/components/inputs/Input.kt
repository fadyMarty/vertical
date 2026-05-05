package com.verticalautomotive.uikit.presentation.components.inputs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import com.verticalautomotive.uikit.common.theme.VerticalTheme

@Composable
fun Input(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    label: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    inputTransformation: InputTransformation? = null,
    outputTransformation: OutputTransformation? = null,
) {
    InputLayout(
        modifier = modifier,
        label = label
    ) { styleModifier ->
        BasicTextField(
            modifier = styleModifier,
            state = state,
            keyboardOptions = keyboardOptions,
            inputTransformation = inputTransformation,
            outputTransformation = outputTransformation,
            lineLimits = TextFieldLineLimits.SingleLine,
            textStyle = VerticalTheme.typography.mainText.copy(
                color = VerticalTheme.colorScheme.onBackground
            ),
            cursorBrush = SolidColor(VerticalTheme.colorScheme.mainButton),
            decorator = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    innerTextField()
                }
            }
        )
    }
}