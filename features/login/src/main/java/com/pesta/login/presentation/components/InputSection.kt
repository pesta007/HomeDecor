package com.pesta.login.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun InputSection(
    label: String,
    modifier: Modifier = Modifier,
    gap: Dp = 4.dp,
    field: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.height(gap))
        field()
    }
}

@Preview
@Composable
private fun InputSectionPreview() {
    Surface {
        InputSection(
            label = "Username or Email",
            Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
        ) {
            InputField(
                placeholder = "example@example.com",
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
        }
    }
}