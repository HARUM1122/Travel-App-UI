package com.example.travelappui.screens

// Jetpack Compose - Layout
import androidx.compose.foundation.layout.*

// Jetpack Compose - Material3
import androidx.compose.material3.Text

// Jetpack Compose - Runtime
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

// Jetpack Compose - UI
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// App-specific
import com.example.travelappui.components.bottom_navigation_bar.NavigationBar

@Composable
fun MainScreen() {
    var currentPageIndex: Int by rememberSaveable { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .padding(WindowInsets.safeDrawing.asPaddingValues())
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 26.dp, vertical = 20.dp)
        ) {
            /// more screens can be added here
            when(currentPageIndex) {
                0 -> HomeScreen()
                else -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("COMING SOON")
                    }
                }
            }
        }
        NavigationBar(
            currentPageIndex,
            onPageSelected = {
                currentPageIndex = it
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
    }
}