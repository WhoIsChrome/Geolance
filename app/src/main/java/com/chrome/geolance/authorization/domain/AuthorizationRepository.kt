package com.chrome.geolance.authorization.domain

import com.chrome.geolance.authorization.domain.model.AuthorizationResponse
import com.chrome.geolance.core.Either
import com.chrome.geolance.core.network.NetworkFailure

interface AuthorizationRepository {

    suspend fun signIn(
        email: String,
        password: String
    ): Either<NetworkFailure, AuthorizationResponse>
}