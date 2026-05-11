package com.verticalautomotive.uikit.presentation.components.bottom_bar

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.verticalautomotive.uikit.common.theme.Gilroy
import com.verticalautomotive.uikit.common.theme.VerticalTheme

@Composable
fun BottomBar(
    items: List<BottomBarItem>,
    onItemClick: (BottomBarItem) -> Unit,
    modifier: Modifier = Modifier,
    windowInsets: WindowInsets = WindowInsets.navigationBars.union(
        WindowInsets.displayCutout
    ),
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(VerticalTheme.colorScheme.onBackground)
            .clipToBounds()
            .windowInsetsPadding(windowInsets)
            .padding(horizontal = 16.dp)
            .padding(top = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items.forEach { item ->
            val contentColor by animateColorAsState(
                targetValue = if (item.selected) {
                    VerticalTheme.colorScheme.mainButton
                } else {
                    VerticalTheme.colorScheme.background
                }
            )

            Column(
                modifier = Modifier
                    .clickable(
                        interactionSource = null,
                        indication = ripple(
                            bounded = false,
                            color = VerticalTheme.colorScheme.mainButton
                        ),
                        onClick = {
                            onItemClick(item)
                        },
                    )
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = ImageVector.vectorResource(item.icon),
                    contentDescription = null,
                    tint = contentColor
                )
                Text(
                    modifier = Modifier.width(72.dp),
                    text = item.label,
                    style = TextStyle(
                        fontFamily = Gilroy,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.3.sp,
                        textAlign = TextAlign.Center,
                        color = contentColor
                    )
                )
            }
        }
    }
}