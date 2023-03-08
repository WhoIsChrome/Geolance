package com.chrome.geolance.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
inline fun <reified UiState : UIState, reified Event> uiStatePreviewSafe(
    viewModel: BaseViewModel<UiState, Event>?,
    preview: () -> UiState
): UiState = viewModel?.uiState?.collectAsState()?.value ?: preview()