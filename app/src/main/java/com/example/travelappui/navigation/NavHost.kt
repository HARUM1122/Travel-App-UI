package com.example.travelappui.navigation

// Jetpack Compose - Core
import androidx.compose.runtime.Composable

// Jetpack Navigation
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// App-specific Screens
import com.example.travelappui.screens.MainScreen
import com.example.travelappui.screens.SplashScreen

@Composable
fun NavigationHost() {
    val navController: NavHostController = rememberNavController()
    NavHost(startDestination = Routes.SplashScreen, navController = navController) {
        composable<Routes.SplashScreen> {
            SplashScreen(navController)
        }
        composable<Routes.MainScreen> {
            MainScreen()
        }
    }
}