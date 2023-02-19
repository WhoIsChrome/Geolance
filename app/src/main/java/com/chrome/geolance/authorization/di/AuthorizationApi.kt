package com.chrome.geolance.authorization.di

import retrofit2.http.POST

interface AuthorizationApi {

    @POST("/v1/user/signin")
    fun signIn(email: String, password: String)
}