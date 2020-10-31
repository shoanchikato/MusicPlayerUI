package com.sample.musicplayerui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.sample.musicplayerui.ui.MusicPlayerUITheme

@Composable
fun Playlists() {
    val items = IntArray(5).toList()
    Column(Modifier.padding(start = 16.dp, end = 16.dp, bottom = 56.dp)) {
        Text("Playlist", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        LazyColumnForIndexed(items = items) { index, _ ->
            PlaylistRow(index + 1, items.size)
        }
    }
}

@Composable
fun PlaylistRow(index: Int, itemsSize: Int) {
    Divider()
    Row(
        Modifier.fillMaxWidth().padding(vertical = 8.dp),
        Arrangement.SpaceBetween,
        Alignment.CenterVertically
    ) {
        Row {
            Box(
                Modifier.padding(end = 8.dp).size(48.dp).border(
                    BorderStroke(4.dp, MaterialTheme.colors.primary),
                    CircleShape
                ), Alignment.Center
            ) {
                Text("$index", fontSize = 32.sp, fontWeight = FontWeight.Medium)
            }
            Column {
                Text("Playlist Name", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                Text("26 songs", fontSize = 14.sp)
            }
        }
        Text("heart emoji")
    }
    if (index == itemsSize) Divider()
}

@Preview(showBackground = true)
@Composable
fun PlaylistPreview() {
    MusicPlayerUITheme {
        Playlists()
    }
}