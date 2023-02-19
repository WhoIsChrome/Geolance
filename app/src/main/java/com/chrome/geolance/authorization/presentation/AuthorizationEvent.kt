package com.chrome.geolance.authorization.presentation

sealed interface AuthorizationEvent {

    data class SignInClick(val email: String, val password: String) : AuthorizationEvent
}