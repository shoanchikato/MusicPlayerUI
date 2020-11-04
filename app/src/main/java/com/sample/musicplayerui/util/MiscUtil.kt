package com.sample.musicplayerui.util

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Receives padding values from Material Design Component Scaffold and automatically adds
// padding values around content to accommodate for BottomAppBar, TopAppBar, etc sizes
@Composable
fun BodyContent(
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit
) {
    Box(modifier) {
        content()
    }
}

@Composable
fun StatefulFavoriteIcon(modifier: Modifier = Modifier) {
    val (selected, onSelect) = remember { mutableStateOf(false) }
    val icon = if (selected) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder
    val color = if (selected) Color.Gray else MaterialTheme.colors.primary

    Icon(
            icon,
            modifier
                    .toggleable(
                            value = selected,
                            onValueChange = onSelect,
                            indication = null
                    )
                    .padding(10.dp),
            color
    )
}