package com.sample.musicplayerui.screens

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.VerticalGradient
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.sample.musicplayerui.ui.MusicPlayerUITheme

@Composable
fun Artists() {
    Column(Modifier.padding(start = 16.dp, end = 16.dp)) {
        Text("Artists", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        LazyColumnForIndexed(items = IntArray(21).toList().chunked(2)) { index, items ->
            ArtistRow(index, items)
        }
    }
}

@Composable
fun ArtistRow(itemIndex: Int, items: List<Int>) {
    val isEven = items.size == 2
    val displayItems = if (isEven) listOf(
        ((itemIndex * 2) + 1),
        ((itemIndex * 2) + 2)
    ) else listOf(((itemIndex * 2) + 1))
    val fillRatio = if (isEven) 1f else .5f
    val horizontalAlignment = if (isEven) Alignment.CenterHorizontally else Alignment.Start
    val colors = listOf(Color.Transparent, MaterialTheme.colors.primary)

    Row {
        displayItems.map { item ->
            Column(
                Modifier.padding(vertical = 16.dp).weight(1f),
                horizontalAlignment = horizontalAlignment
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        Modifier.padding(horizontal = 16.dp).fillMaxSize(fillRatio).aspectRatio(1f)
                            .clip(CircleShape).verticalGradientBackground(colors), Alignment.Center
                    ) {
                        Text("$item", fontSize = 96.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(Modifier.height(8.dp))
                    Text("Imagine Dragons")
                }
            }
        }
    }
}

fun Modifier.verticalGradientBackground(
        colors: List<Color>
) = drawWithCache {
    // Use drawWithCache modifier to create and cache the gradient once size is known or changes.
    val gradient = VerticalGradient(
            startY = 0.0f,
            endY = size.height,
            colors = colors
    )
    onDraw {
        drawRect(brush = gradient)
    }
}

@Preview(showBackground = true)
@Composable
fun ArtistsPreview() {
    MusicPlayerUITheme {
        Artists()
    }
}