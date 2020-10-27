package com.sample.musicplayerui

import androidx.compose.foundation.Text
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.sample.musicplayerui.screens.Albums
import com.sample.musicplayerui.screens.Artists
import com.sample.musicplayerui.screens.Playlists
import com.sample.musicplayerui.screens.Songs
import com.sample.musicplayerui.util.BottomBar

@Composable
fun MusicPlayerUI() {
    val bottomBarLabels = listOf("Songs", "Albums", "Artists", "Playlists")
    val (tabs, selectedTabIndex) = BottomBar(bottomBarLabels)

    Scaffold(
        bottomBar = tabs
    ) {
        when (selectedTabIndex) {
            0 -> Songs()
            1 -> Albums()
            2 -> Artists()
            3 -> Playlists()
            else -> Text("Welcome")
        }
    }
}