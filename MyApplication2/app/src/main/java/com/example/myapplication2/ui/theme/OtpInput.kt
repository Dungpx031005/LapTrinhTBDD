package com.example.myapplication2.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.platform.LocalFocusManager

@Composable
fun OtpInput(length: Int = 5, onValueChange: (String) -> Unit) {
    var codeList by remember { mutableStateOf(List(length) { "" }) }
    val focusRequesters = List(length) { remember { FocusRequester() } }
    val focusManager = LocalFocusManager.current

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 0 until length) {
            OutlinedTextField(
                value = codeList[i],
                onValueChange = { value ->
                    if (value.length <= 1 && value.all { it.isDigit() }) {
                        val newList = codeList.toMutableList()
                        newList[i] = value
                        codeList = newList
                        onValueChange(codeList.joinToString(""))

                        if (value.isNotEmpty()) {
                            if (i < length - 1) {
                                focusRequesters[i + 1].requestFocus()
                            } else {
                                focusManager.clearFocus()
                            }
                        }
                    }
                },
                modifier = Modifier
                    .padding(4.dp)
                    .width(48.dp)
                    .height(56.dp)
                    .focusRequester(focusRequesters[i]),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                ),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.LightGray,
                    focusedBorderColor = MaterialTheme.colorScheme.primary
                ),
                visualTransformation = VisualTransformation.None
            )
        }
    }

    LaunchedEffect(Unit) {
        focusRequesters.first().requestFocus()
    }
}

