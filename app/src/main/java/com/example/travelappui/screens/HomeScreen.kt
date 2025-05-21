package com.example.travelappui.screens

// Jetpack Compose - Foundation
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

// Jetpack Compose - Material3
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider

// Jetpack Compose - Runtime
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

// Jetpack Compose - UI
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// App-specific Imports
import com.example.travelappui.R
import com.example.travelappui.components.GlassCard
import com.example.travelappui.models.PlaceModel
import com.example.travelappui.models.mostViewedPlaces

// Third-party Libraries
import coil.compose.AsyncImage
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.rememberHazeState


@Composable
fun HomeScreen() {
    var currentCategoryIndex: Int by rememberSaveable { mutableIntStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    "Hi, HELI \uD83D\uDC4B",
                    fontSize = 26.sp,
                    color = Color(0xFF2F2F2F),
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    "Explore the world",
                    fontSize = 18.sp,
                    color = Color(0xFF888888)
                )
            }
            Image(
                painter = painterResource(R.drawable.pfp),
                contentDescription = null,
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        SearchPlacesField()
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
        ) {
            Text(
                "Popular Places",
                fontSize = 20.sp,
                color = Color(0xFF2F2F2F),
                fontWeight = FontWeight.SemiBold
            )
            Text(
                "View all",
                fontSize = 14.sp,
                color = Color(0xFF888888),
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            CategoryTabButton(
                text = "Most Viewed",
                onClick = {
                    currentCategoryIndex = 0
                },
                selected = currentCategoryIndex == 0
            )
            CategoryTabButton(
                text = "Nearby",
                onClick = {
                    currentCategoryIndex = 1
                },
                selected = currentCategoryIndex == 1
            )
            CategoryTabButton(
                text = "Latest",
                onClick = {
                    currentCategoryIndex = 2
                },
                selected = currentCategoryIndex == 2
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
        PlacesListView(mostViewedPlaces)

    }

}

@Composable
fun PlacesListView(places: List<PlaceModel>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(places) { place ->
            PlaceCard(place)
        }
    }
}

@Composable
fun PlaceCard(place: PlaceModel) {
    val hazeState = rememberHazeState()
    Surface(
        modifier = Modifier
            .width(240.dp)
            .fillMaxHeight(),
        shape = RoundedCornerShape(20.dp),
        shadowElevation = 8.dp,
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = place.image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .hazeSource(hazeState),
                contentScale = ContentScale.Crop
            )
            GlassCard(
                state = hazeState,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .align(Alignment.BottomCenter)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(14.dp)
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.White,
                                    fontSize = 14.sp
                                )
                            ) {
                                append(place.name + ',')
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xFFCAC8C8),
                                    fontSize = 12.sp
                                )
                            ) {
                                append(' ' + place.country)
                            }

                        },
                        color = Color.White,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Top
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.location),
                            contentDescription = null,
                            modifier = Modifier.size(12.dp),
                            tint = Color(0xFFCAC8C8)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "${place.country}, ${place.city}",
                            fontSize = 12.sp,
                            color = Color(0xFFCAC8C8)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = painterResource(R.drawable.star),
                            contentDescription = null,
                            modifier = Modifier.size(12.dp),
                            tint = Color(0xFFCAC8C8)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = place.ratings,
                            fontSize = 12.sp,
                            color = Color(0xFFCAC8C8)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryTabButton(
    text: String,
    onClick: () -> Unit,
    selected: Boolean
) {
    val interactionSource = remember { MutableInteractionSource() }
    val animatedWidth: Dp by animateDpAsState(
        targetValue = if (selected) 130.dp else 100.dp,
    )
    val textColor: Color = if (selected) Color.White else Color(0xFFC5C5C5)
    val backgroundColor: Color = if (selected) Color(0xFF2F2F2F) else Color(0xFFF0F0F0)
    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(40)
            )
            .width(animatedWidth)
            .height(50.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
       contentAlignment = Alignment.Center
    ) {
        Text(
            text,
            color = textColor,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun SearchPlacesField() {
    var query: String by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(34))
            .border(1.dp, Color(0XFFD2D2D2), RoundedCornerShape(34))
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = query,
            onValueChange = { query = it },
            placeholder = {
                Text("Search places", color = Color(0xFF888888))
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true
        )
        Spacer(modifier = Modifier.weight(1f))
        VerticalDivider(
            color = Color(0XFFD2D2D2),
            modifier = Modifier
                .width(12.dp)
                .height(30.dp)
        )
        Icon(
            painter = painterResource(R.drawable.filter),
            contentDescription = "Filter",
            tint = Color(0xFF888888),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
    }
}