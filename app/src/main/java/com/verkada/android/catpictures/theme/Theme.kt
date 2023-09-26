package com.verkada.android.catpictures.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val _DarkColorPalette = darkColorScheme(
    primary = DarkBlue,
    onPrimary = Color.White,
    primaryContainer = DarkBlue,
    onPrimaryContainer = Color.White,
    secondaryContainer = LighterDarkBlue,
    onSecondaryContainer = Color.White,
)

private val _LightColorPalette = lightColorScheme(
    primary = LighterBlue,
    onPrimary = Color.Black,
    primaryContainer = LighterBlue,
    onPrimaryContainer = Color.Black,
    secondaryContainer = LightBlue,
    onSecondaryContainer = Color.Black,
)

@Composable
fun CatPicturesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        _DarkColorPalette
    } else {
        _LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        content = content,
    )
}
