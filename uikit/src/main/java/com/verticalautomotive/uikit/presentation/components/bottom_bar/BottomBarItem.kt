package com.verticalautomotive.uikit.presentation.components.bottom_bar

import androidx.annotation.DrawableRes

data class BottomBarItem<out T>(
    val selected: Boolean,
    @DrawableRes val icon: Int,
    val label: String,
    val route: T,
)
