package com.verticalautomotive.uikit.presentation.components.indicator

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.verticalautomotive.uikit.common.theme.VerticalTheme

@Composable
fun StatusBar(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(pageCount) { index ->
            val color by animateColorAsState(
                targetValue = if (index == currentPage) {
                    VerticalTheme.colorScheme.onBackground
                } else {
                    VerticalTheme.colorScheme.strokeGrey
                }
            )

            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StatusBarPreview() {
    VerticalTheme {
        StatusBar(
            pageCount = 4,
            currentPage = 2
        )
    }
}