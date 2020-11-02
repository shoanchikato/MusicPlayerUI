package com.sample.musicplayerui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.sample.musicplayerui.util.StatefulFavoriteIcon

@Composable
fun Songs() {
    val items = IntArray(20).toList()

    Column(Modifier.padding(start = 16.dp, end = 16.dp, bottom = 56.dp)) {
        Text("Songs", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        LazyColumnForIndexed(items = items) { index, _ ->
            SongRow(index + 1, items.size)
        }
    }
}

@Composable
fun SongRow(itemCount: Int, items: Int) {
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
                            RoundedCornerShape(6.dp)
                    ), Alignment.Center
            ) {
                Text("$itemCount", fontSize = 32.sp, fontWeight = FontWeight.Medium)
            }
            Column {
                Text("Song Name", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                Text("Artist Name", fontSize = 14.sp)
            }
        }
        StatefulFavoriteIcon()
    }
    if (itemCount == items) Divider()
}

@Preview(showBackground = true)
@Composable
fun SongsPreview() {
    MusicPlayerUITheme {
        Songs()
    }
}