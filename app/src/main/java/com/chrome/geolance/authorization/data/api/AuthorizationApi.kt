package com.chrome.geolance.authorization.data.api

import com.chrome.geolance.authorization.data.model.SignInRequestBody
import com.chrome.geolance.authorization.domain.model.AuthorizationResponse
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthorizationApi {

    @POST("/v1/user/signin")
    suspend fun signIn(
        @Body body: SignInRequestBody
    ): AuthorizationResponse
}