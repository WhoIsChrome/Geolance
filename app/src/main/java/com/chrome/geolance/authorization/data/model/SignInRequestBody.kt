package com.chrome.geolance.authorization.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignInRequestBody(
    @SerialName("email") val email: String,
    @SerialName("password") val password: String,
)
