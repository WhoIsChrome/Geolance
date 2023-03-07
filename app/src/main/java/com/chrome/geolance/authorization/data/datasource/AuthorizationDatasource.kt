package com.chrome.geolance.authorization.data.datasource

import com.chrome.geolance.authorization.data.api.AuthorizationApi
import com.chrome.geolance.authorization.data.model.SignInRequestBody
import com.chrome.geolance.authorization.data.model.SignUpRequestBody
import com.chrome.geolance.authorization.domain.model.AuthorizationResponse
import com.chrome.geolance.authorization.domain.model.RegistrationResponse
import com.chrome.geolance.core.Either
import com.chrome.geolance.core.network.NetworkFailure
import com.chrome.geolance.core.network.networkRequest
import javax.inject.Inject

class AuthorizationDatasource @Inject constructor(private val authorizationApi: AuthorizationApi) {

    suspend fun signIn(
        email: String,
        password: String
    ): Either<NetworkFailure, AuthorizationResponse> = networkRequest {
        authorizationApi.signIn(SignInRequestBody(email, password))
    }

    suspend fun signUp(
        email: String,
        password: String,
        firstName: String,
        lastName: String,
    ): Either<NetworkFailure, RegistrationResponse> = networkRequest {
        authorizationApi.signUp(
            SignUpRequestBody(
                email = email,
                password = password,
                firstName = firstName,
                lastName = lastName,
            )
        )
    }
}