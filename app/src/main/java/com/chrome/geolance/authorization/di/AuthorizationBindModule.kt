package com.chrome.geolance.authorization.di

import com.chrome.geolance.authorization.data.AuthorizationRepositoryImpl
import com.chrome.geolance.authorization.domain.AuthorizationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthorizationBindModule {

    @Singleton
    @Binds
    abstract fun bindAuthorizationRepository(impl: AuthorizationRepositoryImpl): AuthorizationRepository
}