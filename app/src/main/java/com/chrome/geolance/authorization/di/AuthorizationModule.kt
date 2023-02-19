package com.chrome.geolance.authorization.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthorizationModule {

    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): AuthorizationApi {
        return retrofit.create(AuthorizationApi::class.java)
    }
}