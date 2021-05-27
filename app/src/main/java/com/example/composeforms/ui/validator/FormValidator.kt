package com.example.composeforms.ui.validator

import com.example.composeforms.ui.rule.ValidationRule

abstract class FormValidator {
    protected abstract val rules: List<ValidationRule>
    fun applyRules(input: String): String = rules.map { it.validate(input) }
        .firstOrNull { it.isNotBlank() } ?: ""
}