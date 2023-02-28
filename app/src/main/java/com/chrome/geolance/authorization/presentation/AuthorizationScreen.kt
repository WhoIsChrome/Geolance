package com.chrome.geolance.authorization.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.chrome.geolance.ui.theme.AppThemeColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AuthorizationScreen() {

    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.AppThemeColor

    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }

    Surface {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            AuthorizationForm()
        }
    }
}