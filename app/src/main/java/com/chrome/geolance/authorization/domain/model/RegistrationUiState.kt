package com.chrome.geolance.authorization.domain.model

import com.chrome.geolance.core.ui.UIState

data class RegistrationUiState(
    val isLoading: Boolean,
    val error: String? = null,
) : UIState