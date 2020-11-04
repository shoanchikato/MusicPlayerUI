package com.sample.musicplayerui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sample.musicplayerui.screens.Albums
import com.sample.musicplayerui.screens.Artists
import com.sample.musicplayerui.screens.Playlists
import com.sample.musicplayerui.screens.Songs
import com.sample.musicplayerui.util.BodyContent
import com.sample.musicplayerui.util.BottomBar
import com.sample.musicplayerui.util.Screen

@Composable
fun MusicPlayerUI() {
    val navController = rememberNavController()

    Scaffold(
            bottomBar = {
                BottomBar(navController)
            }
    ) {innerPadding ->
        BodyContent(Modifier.padding(innerPadding)){
            NavHost(navController, startDestination = Screen.Songs.route) {
                composable(Screen.Songs.route) { Songs() }
                composable(Screen.Albums.route) { Albums() }
                composable(Screen.Artists.route) { Artists() }
                composable(Screen.Playlists.route) { Playlists() }
            }
        }
    }
}