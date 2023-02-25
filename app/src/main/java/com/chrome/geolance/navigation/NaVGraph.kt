package com.chrome.geolance.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chrome.geolance.authorization.presentation.AuthorizationScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Authorization.route
    ) {
        composable(route = Screen.Authorization.route) {
            AuthorizationScreen(navController = navController)
        }
    }
}