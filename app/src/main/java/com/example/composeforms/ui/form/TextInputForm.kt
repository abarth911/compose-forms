package com.example.composeforms.ui.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeforms.ui.theme.ComposeFormsTheme

@Composable
fun TextInputForm(input: String, title: String, validateInput: (String) -> String, onInputChanged: (String) -> Unit) {
    var error by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(value = input,
            onValueChange = {
                error = validateInput.invoke(it)
                onInputChanged.invoke(it)},
            label = { Text(title) })
        if(error.isNotBlank()){
            Text(text = error, color = Color.Red)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeFormsTheme() {
        TextInputForm("Alex", "First Name", {"Error"}) {}
    }
}
