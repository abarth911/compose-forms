package com.example.composeforms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.composeforms.ui.User
import com.example.composeforms.ui.UserFormViewModel
import com.example.composeforms.ui.form.TextInputForm
import com.example.composeforms.ui.theme.ComposeFormsTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<UserFormViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserInterface(viewModel)


        }
    }

    @Composable
    fun UserInterface(mainViewModel: UserFormViewModel){
        ComposeFormsTheme {
            val state: User by mainViewModel.user.collectAsState()
            // A surface container using the 'background' color from the theme
            Surface(color = MaterialTheme.colors.background) {
                Column {
                    TextInputForm(state.firstName, "First Name") {viewModel.updateFirstName(it)}
                    TextInputForm(state.lastName, "Last Name") {viewModel.updateLastName(it)}
                    TextInputForm(state.dob, "Day of Birth") {viewModel.updateDOB(it)}
                    Button(onClick = { viewModel.saveUser() }){
                        Text("Save")
                    }
                }

            }
        }
    }
}
