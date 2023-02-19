package com.chrome.geolance.navigation

sealed class Screen(val route: String) {
    object Authorization : Screen("authorization_screen")
}
