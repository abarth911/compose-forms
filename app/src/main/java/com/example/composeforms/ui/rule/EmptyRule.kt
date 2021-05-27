package com.example.composeforms.ui.rule

class EmptyRule(): ValidationRule {
    override fun validate(input: String): String  = if (input.isBlank()){
        "Input is empty"
    } else {
        ""
    }
}