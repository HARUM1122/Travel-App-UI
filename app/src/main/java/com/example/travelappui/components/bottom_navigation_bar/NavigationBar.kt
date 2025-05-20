package com.example.travelappui.components.bottom_navigation_bar

// Jetpack Compose - Layout
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth

// Jetpack Compose - Runtime
import androidx.compose.runtime.Composable

// Jetpack Compose - UI
import androidx.compose.ui.Modifier

// App-specific Resources
import com.example.travelappui.R

@Composable
fun NavigationBar(
    currentPageIndex: Int,
    onPageSelected: (index: Int) -> Unit
) {
    val navigationItemIcons: List<Pair<Int, Int>> = listOf(
        R.drawable.home_filled to R.drawable.home_outlined,
        R.drawable.clock_filled to R.drawable.clock_outlined,
        R.drawable.favourite_filled to R.drawable.favourite_outlined,
        R.drawable.user_filled to R.drawable.user_outlined
    )
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        for (i: Int in 0 until navigationItemIcons.size) {
            val iconsPair: Pair<Int, Int> = navigationItemIcons[i]
            NavigationItem(
                selectedIcon = iconsPair.first,
                unSelectedIcon = iconsPair.second,
                onClick = { onPageSelected(i) },
                selected = currentPageIndex == i
            )
        }
    }
}