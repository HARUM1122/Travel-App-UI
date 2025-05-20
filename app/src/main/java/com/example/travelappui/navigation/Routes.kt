package com.example.travelappui.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    data object SplashScreen: Routes()

    @Serializable
    data object MainScreen: Routes()
}