package com.verticalautomotive.uikit.presentation.components.buttons

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.verticalautomotive.uikit.R
import com.verticalautomotive.uikit.common.theme.VerticalTheme

@Composable
fun VerticalIconButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .border(
                width = 1.dp,
                color = VerticalTheme.colorScheme.strokeGrey,
                shape = CircleShape
            )
            .clip(CircleShape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = icon,
            contentDescription = null,
            tint = VerticalTheme.colorScheme.onBackground
        )
    }
}

@Preview
@Composable
private fun VerticalIconButtonPreview() {
    VerticalTheme {
        VerticalIconButton(
            icon = ImageVector.vectorResource(R.drawable.ic_paperclip),
            onClick = {}
        )
    }
}