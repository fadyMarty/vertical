package com.verticalautomotive.uikit.presentation.components.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.then
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.verticalautomotive.uikit.common.theme.Gilroy
import com.verticalautomotive.uikit.common.theme.VerticalTheme

@Composable
fun OtpCodeInput(
    state: TextFieldState,
    isOtpCodeValid: Boolean,
    modifier: Modifier = Modifier,
) {
    BasicTextField(
        modifier = modifier.semantics {
            contentType = ContentType.SmsOtpCode
        },
        state = state,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone
        ),
        lineLimits = TextFieldLineLimits.SingleLine,
        inputTransformation = InputTransformation.maxLength(6).then {
            if (!asCharSequence().isDigitsOnly()) {
                revertAllChanges()
            }
        },
        decorator = {
            val otpCode = state.text.toString()

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
            ) {
                repeat(6) { index ->
                    OtpDigit(
                        number = otpCode.getOrElse(index) { ' ' },
                        isOtpCodeValid = isOtpCodeValid
                    )
                }
            }
        }
    )
}

@Composable
private fun OtpDigit(
    number: Char,
    isOtpCodeValid: Boolean,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .border(
                width = 1.dp,
                color = if (isOtpCodeValid) {
                    VerticalTheme.colorScheme.onBackground
                } else VerticalTheme.colorScheme.strokeGrey,
                shape = CircleShape
            )
            .clip(CircleShape)
            .background(VerticalTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number.toString(),
            style = TextStyle(
                fontFamily = Gilroy,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                lineHeight = 30.sp,
                letterSpacing = 0.sp
            ),
            textAlign = TextAlign.Center
        )
    }
}