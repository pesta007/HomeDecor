package com.pesta.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomTopAppBar(
    label: String,
    modifier: Modifier = Modifier,
    colors: CustomTopAppBarColors = CustomTopAppBarDefaults.customTopAppBarColors(),
    leadingIcon: @Composable BoxScope.() -> Unit = {},
    trailingIcon: @Composable BoxScope.() -> Unit = {},
    leadingIconOnClick: () -> Unit = {},
    trailingIconOnClick: () -> Unit = {},
) {
    CompositionLocalProvider(LocalContentColor provides colors.contentColor) {
        Row(
            modifier = modifier
                .height(56.dp)
                .fillMaxWidth()
                .background(colors.containerColor),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(Modifier.size(56.dp).clickable { leadingIconOnClick() }, contentAlignment = Alignment.Center) {
                leadingIcon()
            }
            Text(
                text = label,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
            Box(Modifier.size(56.dp).clickable { trailingIconOnClick() }, contentAlignment = Alignment.Center) {
                trailingIcon()
            }
        }
    }
}

data class CustomTopAppBarColors(
    val containerColor: Color,
    val contentColor: Color
)

object CustomTopAppBarDefaults{
    @Composable
    fun customTopAppBarColors(
        containerColor: Color = MaterialTheme.colorScheme.primary,
        contentColor: Color = MaterialTheme.colorScheme.onPrimary
    ) = CustomTopAppBarColors(containerColor, contentColor)
}

@Preview
@Composable
private fun CustomTopAppBarPreview() {
    CustomTopAppBar(
        label = "Log In",
        leadingIcon = {
            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(0.5f)
            )
        },
        trailingIcon = {

        }
    )
}