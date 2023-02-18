package com.chrome.geolance.ui.theme.presentation.navigation

sealed class Screen(val route: String) {
    object Authorization : Screen("authorization_screen")
}
