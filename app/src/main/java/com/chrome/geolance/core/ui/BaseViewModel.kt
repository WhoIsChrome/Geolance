package com.chrome.geolance.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel<UiState: UIState, Event> : ViewModel() {

    private val _uiState = MutableStateFlow(createInitialStateInternal())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
    private val events = MutableSharedFlow<Event>(replay = 0)

    init {
        viewModelScope.launch {
            events.collect(::handleEvent)
        }
    }


    protected abstract fun createInitialState(): UiState

    protected suspend fun setState(uiState: UiState) {
        _uiState.emit(uiState)
    }


    protected val currentStateValue: UiState
        get() = _uiState.value

    private fun createInitialStateInternal(): UiState = createInitialState()

    protected abstract suspend fun handleEvent(event: Event)

    fun onEvent(event: Event) {
        viewModelScope.launch {
            events.emit(event)
        }
    }
}