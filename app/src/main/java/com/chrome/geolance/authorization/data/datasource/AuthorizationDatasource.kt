package com.chrome.geolance.authorization.data.datasource

import com.chrome.geolance.authorization.data.api.AuthorizationApi
import com.chrome.geolance.authorization.data.model.SignInRequestBody
import com.chrome.geolance.authorization.domain.model.AuthorizationResponse
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
}