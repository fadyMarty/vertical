package com.verticalautomotive.uikit.presentation.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.verticalautomotive.uikit.R
import com.verticalautomotive.uikit.common.theme.VerticalTheme

@Composable
fun VerticalButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    trailingIcon: ImageVector? = null,
    enabled: Boolean = true,
    containerColor: Color = VerticalTheme.colorScheme.mainButton,
    contentColor: Color = VerticalTheme.colorScheme.onMainButton,
) {
    Row(
        modifier = modifier
            .height(48.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                color = if (enabled) {
                    containerColor
                } else {
                    VerticalTheme.colorScheme.disabledButton
                }
            )
            .clickable(
                enabled = enabled,
                onClick = onClick
            )
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(
            space = 10.dp,
            alignment = Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (trailingIcon != null) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = trailingIcon,
                contentDescription = null,
                tint = if (enabled) {
                    contentColor
                } else {
                    VerticalTheme.colorScheme.disabledText
                }
            )
        }
        Text(
            text = label,
            style = VerticalTheme.typography.button,
            textAlign = TextAlign.Center,
            color = if (enabled) {
                contentColor
            } else {
                VerticalTheme.colorScheme.disabledText
            },
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun VerticalButtonPreview() {
    VerticalTheme {
        VerticalButton(
            modifier = Modifier.fillMaxWidth(),
            label = "Add a car",
            onClick = {},
            trailingIcon = ImageVector.vectorResource(R.drawable.ic_add)
        )
    }
}