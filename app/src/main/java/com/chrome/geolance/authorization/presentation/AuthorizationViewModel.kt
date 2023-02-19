package com.chrome.geolance.authorization.presentation

import com.chrome.geolance.core.FlowViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor() :
    FlowViewModel<AuthorizationState, AuthorizationEvent>() {

    override val initialUi: AuthorizationState
        get() = AuthorizationState(null)

    override val uiFlow: Flow<AuthorizationState>
        get() = TODO("Not yet implemented")

    override suspend fun handleEvent(event: AuthorizationEvent) {
        when(event) {
            is AuthorizationEvent.SignInClick -> TODO()
        }
    }

}