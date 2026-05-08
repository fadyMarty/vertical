package com.verticalautomotive.uikit.presentation.components.bottom_bar

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarItem<out T>(
    val selected: Boolean,
    val icon: ImageVector,
    val label: String,
    val route: T,
)
