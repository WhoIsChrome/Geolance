package com.chrome.geolance.authorization.domain.usecase

import com.chrome.geolance.authorization.domain.AuthorizationRepository
import com.chrome.geolance.authorization.domain.model.AuthorizationResponse
import com.chrome.geolance.core.Either
import com.chrome.geolance.core.network.NetworkFailure
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: AuthorizationRepository
) {

    suspend operator fun invoke(
        email: String,
        password: String
    ): Either<NetworkFailure, AuthorizationResponse> = repository.signIn(email, password)
}