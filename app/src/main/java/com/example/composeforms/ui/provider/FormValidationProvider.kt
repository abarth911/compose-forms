package com.example.composeforms.ui.provider

import com.example.composeforms.ui.validator.FormValidator

/**
 *  provides the [FormValidator]
 */
interface FormValidationProvider {
    fun provideFormValidator(): FormValidator
}