package com.example.larpet.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.larpet.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        NavigationItem(
            title = stringResource(R.string.home),
            icon = Icons.Default.Home
        ),
        NavigationItem(
            title = stringResource(R.string.adoption),
            icon = Icons.Default.Favorite
        ),
        NavigationItem(
            title = stringResource(R.string.events),
            icon = Icons.Default.Event
        ),
        NavigationItem(
            title = stringResource(R.string.calendar),
            icon = Icons.Default.DateRange
        ),
        NavigationItem(
            title = stringResource(R.string.profile),
            icon = Icons.Default.Person
        )
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.title) },
                        label = { Text(item.title) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") { HomeScreen() }
            composable("adoption") { AdoptionScreen() }
            composable("events") { EventsScreen() }
            composable("calendar") { CalendarScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}

data class NavigationItem(
    val title: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
) 