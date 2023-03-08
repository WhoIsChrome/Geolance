package com.chrome.geolance.authorization.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequestBody(
    @SerialName("email") val email: String,
    @SerialName("password") val password: String,
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String,
)
