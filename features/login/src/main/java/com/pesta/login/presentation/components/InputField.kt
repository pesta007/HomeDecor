package com.pesta.login.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.PlatformImeOptions
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    placeholder: String = "",
    inputFieldColors: InputFieldColors = InputFieldDefaults.inputFieldColors(),
    textStyle: TextStyle = InputFieldDefaults.textStyle(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(autoCorrect = false),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    BasicInputField(
        modifier = modifier,
        placeholder = placeholder,
        inputFieldColors = inputFieldColors,
        textStyle = textStyle,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions
    )
}

@Composable
fun PasswordInputField(
    modifier: Modifier = Modifier,
    placeholder: String = "",
    inputFieldColors: InputFieldColors = InputFieldDefaults.inputFieldColors(),
    textStyle: TextStyle = InputFieldDefaults.textStyle(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(autoCorrect = false),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    BasicInputField(
        modifier = modifier,
        placeholder = placeholder,
        inputFieldColors = inputFieldColors,
        textStyle = textStyle,
        keyboardOptions = keyboardOptions.copy(keyboardType = KeyboardType.Password),
        keyboardActions = keyboardActions,
        visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
fun BasicInputField(
    modifier: Modifier = Modifier,
    placeholder: String = "",
    inputFieldColors: InputFieldColors = InputFieldDefaults.inputFieldColors(),
    textStyle: TextStyle = InputFieldDefaults.textStyle(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(autoCorrect = false),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    BasicTextField(
        value = text,
        onValueChange = {text = it},
        modifier = modifier
            .widthIn(min = 200.dp)
            .clip(CircleShape)
            .background(inputFieldColors.containerColor),
        textStyle = textStyle.copy(color = inputFieldColors.contentColor),
        singleLine = true,
        cursorBrush = SolidColor(inputFieldColors.contentColor),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        decorationBox = {innerTextField ->  
            Box(modifier = Modifier.padding(start = 20.dp, end = 16.dp, top = 14.dp, bottom = 14.dp)){
                Text(
                    text = if (text.isEmpty()) placeholder else "",
                    style = textStyle.copy(color = inputFieldColors.placeholderColor)
                )
                innerTextField()
            }
        }

    )
}

data class InputFieldColors(
    val containerColor: Color,
    val contentColor: Color,
    val placeholderColor: Color
)

object InputFieldDefaults{
    @Composable
    fun textStyle(
        textStyle: TextStyle = MaterialTheme.typography.bodyLarge
    ): TextStyle = textStyle

    @Composable
    fun inputFieldColors(
        containerColor: Color = MaterialTheme.colorScheme.surfaceVariant,
        contentColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        placeholderColor: Color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
    ): InputFieldColors = InputFieldColors(containerColor, contentColor, placeholderColor)
}

@Preview
@Composable
private fun InputFieldPreview() {
    Column {
        InputField(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp), placeholder = "Email"
        )
    }
}