package com.chrome.geolance.ui.theme.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Authorization.route
    ) {
        composable(route = Screen.Authorization.route) {

        }
    }
}