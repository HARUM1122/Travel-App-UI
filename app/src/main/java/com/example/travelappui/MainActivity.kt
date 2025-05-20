package com.example.travelappui

// AndroidX Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

// Jetpack Compose - UI
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

// App-specific
import com.example.travelappui.navigation.NavigationHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                scrim = Color.Transparent.toArgb(),
                darkScrim = Color.Black.toArgb()
            ),
            navigationBarStyle = SystemBarStyle.light(
                scrim = Color.Transparent.toArgb(),
                darkScrim = Color.Black.toArgb()
            )
        )
        super.onCreate(savedInstanceState)

        setContent {
            NavigationHost()
        }
    }
}

