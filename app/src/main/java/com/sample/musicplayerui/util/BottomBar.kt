package com.sample.musicplayerui.util

import androidx.annotation.StringRes
import androidx.compose.material.Text
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import androidx.ui.tooling.preview.Preview
import com.sample.musicplayerui.R
import com.sample.musicplayerui.ui.MusicPlayerUITheme

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: Int) {
    object Songs : Screen("songs", R.string.route_songs, R.drawable.songs)
    object Albums : Screen("albums", R.string.route_albums, R.drawable.albums)
    object Artists : Screen("artists", R.string.route_artists, R.drawable.artists)
    object Playlists : Screen("playlists", R.string.route_playlists, R.drawable.playlists)
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(Screen.Songs, Screen.Albums, Screen.Artists, Screen.Playlists)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

    BottomNavigation(
            backgroundColor = MaterialTheme.colors.background,
    ) {
        screens.map { screen ->
            BottomNavigationItem(
                    icon = { Icon(vectorResource(id = screen.icon)) },
                    label = { Text(stringResource(screen.resourceId)) },
                    selected = currentRoute == screen.route,
                    selectedContentColor = Color.Red,
                    unselectedContentColor = Color.Gray,
                    onClick = {
                        // This is the equivalent to popUpTo the start destination
                        navController.popBackStack(navController.graph.startDestination, false)

                        // This if check gives us a "singleTop" behavior where we do not create a
                        // second instance of the composable if we are already on that destination
                        if (currentRoute != screen.route) {
                            navController.navigate(screen.route)
                        }
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    val navController = rememberNavController()

    MusicPlayerUITheme {
        Scaffold(
                bottomBar = { BottomBar(navController) },
                bodyContent = {}
        )
    }
}