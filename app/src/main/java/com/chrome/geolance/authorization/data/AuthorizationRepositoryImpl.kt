package com.chrome.geolance.authorization.data

import com.chrome.geolance.authorization.data.datasource.AuthorizationDatasource
import com.chrome.geolance.authorization.domain.AuthorizationRepository
import com.chrome.geolance.authorization.domain.model.AuthorizationResponse
import com.chrome.geolance.authorization.domain.model.RegistrationResponse
import com.chrome.geolance.core.Either
import com.chrome.geolance.core.network.NetworkFailure
import javax.inject.Inject

class AuthorizationRepositoryImpl @Inject constructor(
    private val remoteDatasource: AuthorizationDatasource
) : AuthorizationRepository {

    override suspend fun signIn(
        email: String,
        password: String
    ): Either<NetworkFailure, AuthorizationResponse> = remoteDatasource.signIn(email, password)

    override suspend fun signUp(
        email: String,
        password: String,
        firstName: String,
        lastName: String
    ): Either<NetworkFailure, RegistrationResponse> = remoteDatasource.signUp(
        email = email,
        password = password,
        firstName = firstName,
        lastName = lastName
    )
}