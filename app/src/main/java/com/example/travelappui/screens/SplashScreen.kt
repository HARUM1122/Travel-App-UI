package com.example.travelappui.screens

// Kotlin standard library
import kotlinx.coroutines.delay

// AndroidX Compose - Foundation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

// AndroidX Compose - Material
import androidx.compose.material3.Text

// AndroidX Compose - Runtime
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

// AndroidX Compose - UI
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Navigation
import androidx.navigation.NavController

// App-specific
import com.example.travelappui.R
import com.example.travelappui.navigation.Routes

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000)
        navController.popBackStack()
        navController.navigate(Routes.MainScreen)
    }
    Box(
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF0172B2),
                        Color(0xFF001645),
                    )
                )
            )
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Travel",
                style = TextStyle(
                    fontFamily = FontFamily(
                        Font(
                            R.font.lobster
                        )
                    ),
                    fontSize = 40.sp,
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                "Find Your Dream\nDestination With Us",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}