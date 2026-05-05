package com.verticalautomotive.uikit.common.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun VerticalTheme(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalVerticalColorScheme provides LightColorScheme,
        LocalVerticalTypography provides Typography
    ) {
        MaterialTheme(
            colorScheme = mapMaterialColorScheme(LightColorScheme),
            content = content
        )
    }
}

object VerticalTheme {
    val colorScheme: VerticalColorScheme
        @Composable
        get() = LocalVerticalColorScheme.current

    val typography: VerticalTypography
        @Composable
        get() = LocalVerticalTypography.current
}

private fun mapMaterialColorScheme(
    verticalColorScheme: VerticalColorScheme,
): ColorScheme {
    return lightColorScheme(
        background = verticalColorScheme.background,
        onBackground = verticalColorScheme.onBackground,
        surface = verticalColorScheme.background,
        onSurface = verticalColorScheme.onBackground,
        onSurfaceVariant = verticalColorScheme.mainGrey,
        outline = verticalColorScheme.strokeGrey,
        primary = verticalColorScheme.mainButton,
        onPrimary = verticalColorScheme.onMainButton
    )
}