package com.verticalautomotive.uikit.presentation.components.buttons

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.verticalautomotive.uikit.common.theme.VerticalTheme

@Composable
fun VerticalTextButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textAlign: TextAlign = TextAlign.Center,
) {
    val alpha by animateFloatAsState(
        targetValue = if (enabled) 1f else 0.2f
    )

    Text(
        modifier = modifier
            .alpha(alpha)
            .clickable(
                interactionSource = null,
                indication = null,
                enabled = enabled,
                onClick = onClick
            ),
        text = label,
        style = VerticalTheme.typography.mainText,
        textAlign = textAlign,
        color = VerticalTheme.colorScheme.linkText
    )
}

@Preview(showBackground = true)
@Composable
private fun VerticalTextButtonPreview() {
    VerticalTheme {
        VerticalTextButton(
            modifier = Modifier.fillMaxWidth(),
            label = "Resend Code",
            onClick = {}
        )
    }
}