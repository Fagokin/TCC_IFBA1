package com.example.larpet.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.larpet.R
import com.example.larpet.navigation.Screen

@Composable
fun MainScreen(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text(stringResource(R.string.home)) },
                    selected = currentRoute == Screen.Home.route,
                    onClick = { navController.navigate(Screen.Home.route) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Pets, contentDescription = null) },
                    label = { Text(stringResource(R.string.adoption)) },
                    selected = currentRoute == Screen.Adoption.route,
                    onClick = { navController.navigate(Screen.Adoption.route) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Event, contentDescription = null) },
                    label = { Text(stringResource(R.string.events)) },
                    selected = currentRoute == Screen.Events.route,
                    onClick = { navController.navigate(Screen.Events.route) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.CalendarMonth, contentDescription = null) },
                    label = { Text(stringResource(R.string.calendar)) },
                    selected = currentRoute == Screen.Calendar.route,
                    onClick = { navController.navigate(Screen.Calendar.route) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = null) },
                    label = { Text(stringResource(R.string.profile)) },
                    selected = currentRoute == Screen.Profile.route,
                    onClick = { navController.navigate(Screen.Profile.route) }
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // O conteúdo será gerenciado pelo NavHost
        }
    }
} 