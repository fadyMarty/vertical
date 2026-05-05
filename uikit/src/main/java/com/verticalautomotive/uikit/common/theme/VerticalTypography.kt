package com.verticalautomotive.uikit.common.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.verticalautomotive.uikit.R

val Gilroy = FontFamily(
    Font(R.font.gilroy_regular, FontWeight.Normal),
    Font(R.font.gilroy_medium, FontWeight.Medium),
    Font(R.font.gilroy_semibold, FontWeight.SemiBold)
)

@Immutable
data class VerticalTypography(
    val h1: TextStyle,
    val h2: TextStyle,
    val h4: TextStyle,
    val input: TextStyle,
    val button: TextStyle,
    val mainText: TextStyle,
    val signature: TextStyle,
    val indicator: TextStyle,
)

val Typography = VerticalTypography(
    h1 = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        lineHeight = 39.sp,
        letterSpacing = 0.sp
    ),
    h2 = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    h4 = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    input = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    button = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.sp
    ),
    mainText = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 19.sp,
        letterSpacing = 0.sp
    ),
    signature = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 17.sp,
        letterSpacing = 0.sp
    ),
    indicator = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.em
    )
)

val LocalVerticalTypography = staticCompositionLocalOf {
    VerticalTypography(
        h1 = TextStyle.Default,
        h2 = TextStyle.Default,
        h4 = TextStyle.Default,
        input = TextStyle.Default,
        button = TextStyle.Default,
        mainText = TextStyle.Default,
        signature = TextStyle.Default,
        indicator = TextStyle.Default
    )
}