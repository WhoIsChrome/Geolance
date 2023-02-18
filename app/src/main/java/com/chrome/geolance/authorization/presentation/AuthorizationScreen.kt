package com.chrome.geolance.authorization.presentation

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.chrome.geolance.ui.theme.AppThemeColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: AuthorizationViewModel = hiltViewModel()
) {

    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.AppThemeColor

    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }
}