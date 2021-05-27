package com.example.composeforms.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeforms.ui.provider.FirstNameValidatorProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserFormViewModel: ViewModel() {
    private val mutableUser = MutableStateFlow(User("", "", ""))
    val user: StateFlow<User> = mutableUser

    fun validateFirstName(input: String) : String{
        val validator = FirstNameValidatorProvider().provideFormValidator()
        return validator.applyRules(input)
    }

    fun updateFirstName(firstName: String){
        val user = mutableUser.value
        viewModelScope.launch {
            mutableUser.emit(user.copy(firstName = firstName))
        }
    }

    fun updateLastName(lastName: String){
        val user = mutableUser.value
        viewModelScope.launch {
            mutableUser.emit(user.copy(lastName = lastName))
        }
    }

    fun updateDOB(dob: String){
        val user = mutableUser.value
        viewModelScope.launch {
            mutableUser.emit(user.copy(dob = dob))
        }
    }

    fun saveUser() {
        println("firstname: ${mutableUser.value.firstName}")
        println("lastname: ${mutableUser.value.lastName}")
        println("dob: ${mutableUser.value.dob}")
    }
}
