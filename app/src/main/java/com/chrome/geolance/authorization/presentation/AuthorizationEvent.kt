package com.chrome.geolance.authorization.presentation

sealed interface AuthorizationEvent {

    data class EmailChanged(val email: String) : AuthorizationEvent

    data class PasswordChanged(val password: String) : AuthorizationEvent

    data class SignInClick(val email: String, val password: String) : AuthorizationEvent
}