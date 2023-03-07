package com.chrome.geolance.authorization.data.api

import com.chrome.geolance.authorization.data.model.SignInRequestBody
import com.chrome.geolance.authorization.data.model.SignUpRequestBody
import com.chrome.geolance.authorization.domain.model.AuthorizationResponse
import com.chrome.geolance.authorization.domain.model.RegistrationResponse
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthorizationApi {

    @POST("/v1/user/signin")
    suspend fun signIn(
        @Body body: SignInRequestBody
    ): AuthorizationResponse

    @POST("/v1/user/signup")
    suspend fun signUp(
        @Body body: SignUpRequestBody
    ): RegistrationResponse
}