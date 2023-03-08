package com.chrome.geolance.authorization.presentation.registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.chrome.geolance.authorization.domain.model.RegistrationUiState
import com.chrome.geolance.authorization.domain.usecase.SignUpUseCase
import com.chrome.geolance.core.fold
import com.chrome.geolance.core.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) :
    BaseViewModel<RegistrationUiState, RegistrationEvent>() {

    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set
    var firstName by mutableStateOf("")
        private set
    var lastName by mutableStateOf("")
        private set

    override fun createInitialState(): RegistrationUiState = RegistrationUiState(isLoading = false)

    override suspend fun handleEvent(event: RegistrationEvent) {
        when (event) {
            is RegistrationEvent.EmailChanged -> handleEmailChanged(event)
            is RegistrationEvent.FirstNameChanged -> handleFirstNameChanged(event)
            is RegistrationEvent.LastNameChanged -> handleLastNameChanged(event)
            is RegistrationEvent.PasswordChanged -> handlePasswordChanged(event)
            is RegistrationEvent.SignUpClick -> handleSignUpClick(event)
        }
    }

    private fun handleEmailChanged(event: RegistrationEvent.EmailChanged) {
        viewModelScope.launch {
            email = event.email
        }
    }

    private fun handlePasswordChanged(event: RegistrationEvent.PasswordChanged) {
        viewModelScope.launch {
            password = event.password
        }
    }

    private fun handleFirstNameChanged(event: RegistrationEvent.FirstNameChanged) {
        viewModelScope.launch {
            firstName = event.firstName
        }
    }

    private fun handleLastNameChanged(event: RegistrationEvent.LastNameChanged) {
        viewModelScope.launch {
            lastName = event.lastName
        }
    }

    private fun handleSignUpClick(event: RegistrationEvent.SignUpClick) {
        viewModelScope.launch {
            signUpUseCase(
                email = event.email,
                password = event.password,
                firstName = event.firstName,
                lastName = event.lastName,
            ).fold(
                ifLeft = {
                    Timber.d("Registration fail")
                },
                ifRight = {
                    Timber.d("Registration successful")
                }
            )
        }
    }
}