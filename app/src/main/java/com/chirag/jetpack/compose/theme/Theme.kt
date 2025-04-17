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

//@Composable
//fun ChiragAppTheme(
//    useDarkTheme: Boolean = isSystemInDarkTheme(),
//    content: @Composable() () -> Unit
//) {
//    val context = LocalContext.current
//    val colors = when {
//        (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) -> {
//            if (useDarkTheme) dynamicDarkColorScheme(context)
//            else dynamicLightColorScheme(context)
//        }
//
//        useDarkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }
//
//    val view = LocalView.current
//    if (!view.isInEditMode) {
//        SideEffect {
//            val window = (view.context as Activity).window
//            window.statusBarColor = colors.primary.toArgb()
//            WindowCompat
//                .getInsetsController(window, view)
//                .isAppearanceLightStatusBars = useDarkTheme
//        }
//    }
//
//    MaterialTheme(
//        colorScheme = colors,
//        content = content
//    )
//}