package com.verticalautomotive.uikit.presentation.components.toolbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun Toolbar(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    title: String? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
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
            icon = ImageVector.vectorResource(R.drawable.ic_arrow_left),
            onClick = onBackClick,
            containerColor = VerticalTheme.colorScheme.background
        )
        Row(
            modifier = Modifier
                .width(
                    width = if (leadingIcon != null) {
                        192.dp
                    } else 227.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            leadingIcon?.invoke()
            if (title != null) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontFamily = Gilroy,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        lineHeight = 25.sp,
                        letterSpacing = 0.sp,
                        textAlign = TextAlign.Center
                    ),
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}