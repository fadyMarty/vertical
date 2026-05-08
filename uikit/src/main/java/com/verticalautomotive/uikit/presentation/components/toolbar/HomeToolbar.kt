package com.verticalautomotive.uikit.presentation.components.toolbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.verticalautomotive.uikit.R
import com.verticalautomotive.uikit.common.theme.Gilroy
import com.verticalautomotive.uikit.common.theme.VerticalTheme
import com.verticalautomotive.uikit.presentation.components.buttons.VerticalIconButton

@Composable
fun HomeToolbar(
    onUserClick: () -> Unit,
    onNotificationClick: () -> Unit,
    modifier: Modifier = Modifier,
    title: String,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        VerticalIconButton(
            modifier = modifier,
            icon = ImageVector.vectorResource(R.drawable.ic_user),
            onClick = onUserClick,
            containerColor = VerticalTheme.colorScheme.onBackground,
            contentColor = VerticalTheme.colorScheme.background
        )
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            style = TextStyle(
                fontFamily = Gilroy,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                lineHeight = 25.sp,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Center,
                color = VerticalTheme.colorScheme.background
            ),
            overflow = TextOverflow.Ellipsis
        )
        VerticalIconButton(
            modifier = modifier,
            icon = ImageVector.vectorResource(R.drawable.ic_notification),
            onClick = onNotificationClick,
            containerColor = VerticalTheme.colorScheme.onBackground,
            contentColor = VerticalTheme.colorScheme.background
        )
    }
}