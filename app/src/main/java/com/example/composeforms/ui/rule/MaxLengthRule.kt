package com.example.composeforms.ui.rule

class MaxLengthRule(private val maxLength: Int): ValidationRule {
    override fun validate(input: String): String  = if (input.length > maxLength){
            "Content too long"
        } else {
            ""
        }
}