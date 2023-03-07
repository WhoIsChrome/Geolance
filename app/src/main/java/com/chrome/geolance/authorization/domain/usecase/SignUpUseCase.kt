package com.chrome.geolance.authorization.domain.usecase

import com.chrome.geolance.authorization.domain.AuthorizationRepository
import com.chrome.geolance.authorization.domain.model.RegistrationResponse
import com.chrome.geolance.core.Either
import com.chrome.geolance.core.network.NetworkFailure
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val repository: AuthorizationRepository) {

    suspend operator fun invoke(
        email: String,
        password: String,
        firstName: String,
        lastName: String,
    ): Either<NetworkFailure, RegistrationResponse> = repository.signUp(
        email = email,
        password = password,
        firstName = firstName,
        lastName = lastName
    )
}