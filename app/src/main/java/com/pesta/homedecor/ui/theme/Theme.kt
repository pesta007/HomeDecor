package com.pesta.homedecor.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable



private val LightColorScheme = lightColorScheme(
    primary = Salmon,
    secondary = Beige
)

@Composable
fun HomeDecorTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}