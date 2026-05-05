package com.verticalautomotive.uikit.common.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class VerticalColorScheme(
    val background: Color,
    val widgetBackground: Color,
    val onBackground: Color,
    val strokeGrey: Color,
    val mainGrey: Color,
    val mainButton: Color,
    val onMainButton: Color,
    val disabledButton: Color,
    val disabledText: Color,
    val linkText: Color,
    val rating: Color,
    val success: Color,
)

val LightColorScheme = VerticalColorScheme(
    background = VerticalPalette.MainWhiteBg,
    widgetBackground = VerticalPalette.WidgetBg,
    onBackground = VerticalPalette.MainBlack,
    strokeGrey = VerticalPalette.StrokeGrey,
    mainGrey = VerticalPalette.MainGrey,
    mainButton = VerticalPalette.MainButton,
    onMainButton = VerticalPalette.MainWhiteBg,
    disabledButton = VerticalPalette.DisabledButton,
    disabledText = VerticalPalette.DisabledText,
    linkText = VerticalPalette.LinkText,
    rating = VerticalPalette.Rating,
    success = VerticalPalette.Success
)

val LocalVerticalColorScheme = staticCompositionLocalOf {
    VerticalColorScheme(
        background = Color.Unspecified,
        widgetBackground = Color.Unspecified,
        onBackground = Color.Unspecified,
        strokeGrey = Color.Unspecified,
        mainGrey = Color.Unspecified,
        mainButton = Color.Unspecified,
        onMainButton = Color.Unspecified,
        disabledButton = Color.Unspecified,
        disabledText = Color.Unspecified,
        linkText = Color.Unspecified,
        rating = Color.Unspecified,
        success = Color.Unspecified
    )
}