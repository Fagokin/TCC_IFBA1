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
import androidx.navigation.compose.rememberNavController
import com.example.larpet.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(parentNavController: NavHostController) {
    var selectedItem by remember { mutableStateOf(0) }
    val navController = rememberNavController()
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

    // Map navigation items to their routes
    val routes = listOf("home", "adoption", "events", "calendar", "profile")

    // Handle navigation when bottom bar item is selected
    LaunchedEffect(selectedItem) {
        navController.navigate(routes[selectedItem]) {
            popUpTo(routes[0]) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

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
            composable("home") { HomeScreen(navController) }
            composable("adoption") { AdoptionScreen(navController) }
            composable("events") { EventsScreen(navController) }
            composable("calendar") { CalendarScreen(navController) }
            composable("profile") { ProfileScreen(navController) }
        }
    }
}

data class NavigationItem(
    val title: String,
    val iconResId: Int
) 