package com.chirag.jetpack.compose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = lightColorScheme(
    primary = ColorAccent,
    secondary = ColorPrimary,
    tertiary = ColorPrimaryDark,
    background = BgColor,
    surface = BgColor,
)

private val LightColorScheme = lightColorScheme(
    primary = ColorAccent,
    secondary = ColorPrimary,
    tertiary = ColorPrimaryDark,
    background = BgColor,
    surface = BgColor,
)

@Composable
fun ChiragAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}