package com.chrome.geolance.authorization.presentation.authorization

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.chrome.geolance.authorization.domain.model.AuthorizationUiState
import com.chrome.geolance.authorization.domain.usecase.SignInUseCase
import com.chrome.geolance.core.fold
import com.chrome.geolance.core.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
) : BaseViewModel<AuthorizationUiState, AuthorizationEvent>() {

    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set

    override fun createInitialState(): AuthorizationUiState =
        AuthorizationUiState(
            isLoading = false,
        )

    override suspend fun handleEvent(event: AuthorizationEvent) {
        when (event) {
            is AuthorizationEvent.SignInClick -> handleSignInClicked(event)
            is AuthorizationEvent.EmailChanged -> handleEmailChanged(event)
            is AuthorizationEvent.PasswordChanged -> handlePasswordChanged(event)
        }
    }

    private fun handleEmailChanged(event: AuthorizationEvent.EmailChanged) {
        viewModelScope.launch {
            email = event.email
        }
    }

    private fun handlePasswordChanged(event: AuthorizationEvent.PasswordChanged) {
        viewModelScope.launch {
            password = event.password
        }
    }

    private fun handleSignInClicked(event: AuthorizationEvent.SignInClick) {
        viewModelScope.launch {
            setState(
                currentStateValue.copy(
                    isLoading = true
                )
            )
            signInUseCase(event.email, event.password).fold(
                ifLeft = {
                    Timber.d("SignIn failed")
                    setState(
                        currentStateValue.copy(
                            isLoading = false,
                            error = ""
                        )
                    )
                },
                ifRight = {
                    Timber.d("SignIn successfully: $it")
                    currentStateValue.copy(
                        isLoading = false,
                        error = null
                    )
                }
            )
        }
    }
}