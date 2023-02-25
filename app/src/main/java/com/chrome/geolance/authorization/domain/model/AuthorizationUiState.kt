package com.chrome.geolance.authorization.domain.model

import com.chrome.geolance.core.ui.UIState

data class AuthorizationUiState(
    val isLoading: Boolean,
    val email: String,
    val password: String,
    val error: String? = null
): UIState
