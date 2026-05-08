package com.verticalautomotive.android.presentation.welcome.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun LoginButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Icon(
        modifier = modifier
            .size(48.dp)
            .clickable(
                interactionSource = null,
                indication = null,
                onClick = onClick
            ),
        imageVector = icon,
        contentDescription = null
    )
}