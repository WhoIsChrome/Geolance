package com.chrome.geolance.core.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ErrorResponse {
    val error: BackendError? = null
}

@Serializable
data class BackendError(@SerialName("type") val errorType: String)