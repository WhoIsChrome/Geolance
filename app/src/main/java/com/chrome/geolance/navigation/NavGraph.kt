package com.chrome.geolance.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chrome.geolance.authorization.presentation.authorization.AuthorizationScreen
import com.chrome.geolance.authorization.presentation.registration.RegistrationScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Authorization.route
    ) {
        composable(route = Screen.Authorization.route) {
            AuthorizationScreen(
                goToRegistration = {
                    navController.navigate(Screen.Registration.route)
                }
            )
        }
        composable(route = Screen.Registration.route) {
            RegistrationScreen(
                goToAuthorization = {
                    navController.navigate(Screen.Authorization.route)
                }
            )
        }
    }
}