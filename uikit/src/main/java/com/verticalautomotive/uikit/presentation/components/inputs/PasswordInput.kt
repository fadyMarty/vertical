package com.verticalautomotive.uikit.presentation.components.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material3.Icon
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.verticalautomotive.uikit.R
import com.verticalautomotive.uikit.common.theme.VerticalTheme

@Composable
fun PasswordInput(
    state: TextFieldState,
    isPasswordVisible: Boolean,
    onToggleVisibilityClick: () -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
) {
    InputLayout(
        modifier = modifier,
        label = label
    ) { styleModifier ->
        BasicSecureTextField(
            modifier = styleModifier,
            state = state,
            textObfuscationMode = if (isPasswordVisible) {
                TextObfuscationMode.Visible
            } else TextObfuscationMode.Hidden,
            textObfuscationCharacter = ' ',
            textStyle = VerticalTheme.typography.mainText.copy(
                color = VerticalTheme.colorScheme.onBackground
            ),
            cursorBrush = SolidColor(VerticalTheme.colorScheme.mainButton),
            decorator = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (!isPasswordVisible) {
                            repeat(state.text.length) {
                                Box(
                                    modifier = Modifier
                                        .size(8.dp)
                                        .clip(CircleShape)
                                        .background(VerticalTheme.colorScheme.onBackground)
                                )
                            }
                        } else {
                            innerTextField()
                        }
                    }
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .clickable(
                                interactionSource = null,
                                indication = ripple(bounded = false),
                                onClick = onToggleVisibilityClick
                            ),
                        imageVector = if (isPasswordVisible) {
                            ImageVector.vectorResource(R.drawable.ic_eye)
                        } else {
                            ImageVector.vectorResource(R.drawable.ic_eye_slash)
                        },
                        contentDescription = null,
                        tint = VerticalTheme.colorScheme.mainGrey
                    )
                }
            }
        )
    }
}