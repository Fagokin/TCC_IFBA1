package com.example.larpet.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
            iconResId = R.drawable.ic_home
        ),
        NavigationItem(
            title = stringResource(R.string.adoption),
            iconResId = R.drawable.ic_adoption
        ),
        NavigationItem(
            title = stringResource(R.string.events),
            iconResId = R.drawable.ic_events
        ),
        NavigationItem(
            title = stringResource(R.string.calendar),
            iconResId = R.drawable.ic_calendar
        ),
        NavigationItem(
            title = stringResource(R.string.profile),
            iconResId = R.drawable.ic_profile
        )
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(painterResource(item.iconResId), contentDescription = item.title) },
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
    val iconResId: Int
) 