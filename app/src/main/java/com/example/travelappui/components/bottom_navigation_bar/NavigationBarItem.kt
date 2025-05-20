package com.example.travelappui.components.bottom_navigation_bar

// Jetpack Compose - Foundation
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape

// Jetpack Compose - Material
import androidx.compose.material3.Icon

// Jetpack Compose - Runtime
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

// Jetpack Compose - UI
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun NavigationItem(
    selectedIcon: Int,
    unSelectedIcon: Int,
    selected: Boolean,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = Modifier.clickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = onClick
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Icon(
            painter = painterResource(
                if (selected) selectedIcon else unSelectedIcon
            ),
            contentDescription = "Filter",
            tint = if (!selected) Color(0xFF888888) else Color(0xFF2F2F2F),
            modifier = Modifier.size(25.dp)
        )
        Box(
            modifier = Modifier
                .background(
                    if (selected) Color(0xFFFF4A4A) else Color.Transparent,
                    shape = CircleShape
                )
                .size(8.dp)
        )
    }
}