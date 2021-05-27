package com.example.composeforms.ui.rule

interface ValidationRule {
    fun validate(input: String): String
}