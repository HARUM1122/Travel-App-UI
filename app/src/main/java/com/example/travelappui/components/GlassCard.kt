package com.example.travelappui.components

// Jetpack Compose - Layout
import androidx.compose.foundation.layout.*

// Jetpack Compose - Runtime
import androidx.compose.runtime.Composable

// Jetpack Compose - UI
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Haze Library
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.hazeEffect

@Composable
fun GlassCard(
    state: HazeState,
    modifier: Modifier = Modifier,
    content: @Composable (BoxScope.() -> Unit)
) {
    Box(
        modifier = modifier
            .hazeEffect(
                state = state,
                style = HazeStyle(
                    backgroundColor = Color(0xFF1D1D1D),
                    blurRadius = 32.dp,
                    tints = emptyList()
                )
            ),
        content = content
    )
}