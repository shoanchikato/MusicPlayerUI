package com.sample.musicplayerui.util

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.sample.musicplayerui.ui.MusicPlayerUITheme

@Composable
fun CustomBottomBar(bottomBarLabels: List<Any>): Pair<@Composable () -> Unit, Int> {
    // ISSUE: hardcoded bottom = 40.dp padding on all views/containers
    // so that bottomBar doesn't cover other views
    val (selectedTabIndex, setSelectedTabIndex) = remember { mutableStateOf(0) }
    val onSelect: (Int) -> Unit = { tab -> setSelectedTabIndex(tab) }

    val tabs: @Composable () -> Unit = {
        BottomAppBar(Modifier.fillMaxWidth(), MaterialTheme.colors.background ) {
            bottomBarLabels.mapIndexed { index, _ ->
                val selectedAccentColor: Color =
                    if (index == selectedTabIndex) Color.Red else MaterialTheme.colors.primary
                Box(
                    Modifier
                        .clickable(onClick = { onSelect(index) }, indication = null)
                        .weight(1f)
                        .padding(10.dp),
                    Alignment.Center

                ) {
                    Text("${bottomBarLabels[index]}", color = selectedAccentColor)
                }
            }
        }
    }
    return Pair(tabs, selectedTabIndex)
}

@Preview(showBackground = true)
@Composable
fun CustomBottomBarPreview() {
    val bottomBarLabels = listOf("Songs", "Albums", "Artists", "Playlists")
    val (tabs, _) = CustomBottomBar(bottomBarLabels)
    MusicPlayerUITheme {
        Scaffold(
            bottomBar = tabs,
            bodyContent = {}
        )
    }
}