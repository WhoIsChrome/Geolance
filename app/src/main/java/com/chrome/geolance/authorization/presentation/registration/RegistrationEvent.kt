package com.chrome.geolance.authorization.presentation.registration

sealed interface RegistrationEvent {
    data class EmailChanged(val email: String) : RegistrationEvent
    data class PasswordChanged(val password: String) : RegistrationEvent
    data class FirstNameChanged(val firstName: String) : RegistrationEvent
    data class LastNameChanged(val lastName: String) : RegistrationEvent
    data class SignUpClick(
        val email: String,
        val password: String,
        val firstName: String,
        val lastName: String
    ) : RegistrationEvent
}