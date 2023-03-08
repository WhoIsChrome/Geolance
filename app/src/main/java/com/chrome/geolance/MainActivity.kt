package com.chrome.geolance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chrome.geolance.navigation.NavGraph
import com.chrome.geolance.ui.theme.AppThemeColor
import com.chrome.geolance.ui.theme.GeolanceTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val systemUiController = rememberSystemUiController()
            val systemBarColor = MaterialTheme.colors.AppThemeColor

            SideEffect {
                systemUiController.setStatusBarColor(
                    color = systemBarColor
                )
            }

            GeolanceTheme {
                navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}