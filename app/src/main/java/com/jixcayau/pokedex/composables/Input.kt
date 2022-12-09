package com.jixcayau.pokedex.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.utils.StringValidations

@Composable
fun Input(
    @StringRes title: Int,
    value: MutableState<String>,
    type: InputType = InputType.Text,
) {
    val isTextVisible = remember { mutableStateOf(type.isInitialVisible()) }
    val containsError = remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value.value,
        onValueChange = {
            value.value = it
            containsError.value = !type.validText(it)
        },
        label = {
            Text(
                text = stringResource(
                    title,
                ),
            )
        },
        singleLine = true,
        isError = containsError.value,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Colors.Accent,
            unfocusedBorderColor = Colors.AuthAccentGradient,
            focusedLabelColor = Colors.Accent,
            unfocusedLabelColor = Colors.AuthAccentGradient,
            errorBorderColor = Colors.Error,
            errorLabelColor = Colors.Error,
            errorCursorColor = Colors.Error,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = type.keyboardType(),
        ),
        visualTransformation = transform(isTextVisible),
        trailingIcon = type.trailingIcon(isTextVisible),
        modifier = Modifier.fillMaxWidth(),
    )
}

enum class InputType {
    Text, Email, Password,
}

fun InputType.keyboardType(): KeyboardType {
    return when (this) {
        InputType.Text -> KeyboardType.Text
        InputType.Email -> KeyboardType.Email
        InputType.Password -> KeyboardType.Password
    }
}


fun InputType.isInitialVisible(): Boolean {
    return this != InputType.Password
}

fun transform(
    isTextVisible: MutableState<Boolean>,
): VisualTransformation {
    return if (!isTextVisible.value) PasswordVisualTransformation()
    else VisualTransformation.None
}

fun InputType.trailingIcon(
    isTextVisible: MutableState<Boolean>,
): @Composable (() -> Unit)? {
    if (this == InputType.Password) {
        return {
            val image = if (isTextVisible.value) Icons.Default.Share
            else Icons.Default.Add

            IconButton(
                onClick = {
                    isTextVisible.value = !isTextVisible.value
                },
            ) {
                Icon(image, "")
            }
        }
    }

    return null
}

/**
 * Return true when the value doesn't match the requirements
 */
fun InputType.validText(value: String): Boolean {
    if (value.trim().isEmpty()) return true

    return when (this) {
        InputType.Text -> StringValidations.validText(value)
        InputType.Email -> StringValidations.validEmail(value)
        InputType.Password -> StringValidations.validPassword(value)
    }
}
