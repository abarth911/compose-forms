package com.example.composeforms.ui.validator

import com.example.composeforms.ui.rule.EmptyRule
import com.example.composeforms.ui.rule.MaxLengthRule
import com.example.composeforms.ui.rule.ValidationRule

class DefaultTextInputFormValidator: FormValidator() {
    override val rules: List<ValidationRule>
        get() = listOf(EmptyRule(), MaxLengthRule(5))
}