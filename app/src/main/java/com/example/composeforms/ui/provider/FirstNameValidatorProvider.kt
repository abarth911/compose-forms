package com.example.composeforms.ui.provider

import com.example.composeforms.ui.validator.DefaultTextInputFormValidator
import com.example.composeforms.ui.validator.FormValidator

class FirstNameValidatorProvider: FormValidationProvider {
    override fun provideFormValidator(): FormValidator  = DefaultTextInputFormValidator()
}