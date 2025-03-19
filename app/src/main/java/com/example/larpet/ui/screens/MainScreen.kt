package com.example.larpet.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.example.larpet.R
import com.example.larpet.navigation.NavGraph
import com.example.larpet.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    
    Scaffold(
        bottomBar = {
            NavigationBar {
                val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
                
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                    label = { Text(stringResource(R.string.home)) },
                    selected = currentRoute == Screen.Home.route,
                    onClick = { navController.navigate(Screen.Home.route) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Pets, contentDescription = null) },
                    label = { Text(stringResource(R.string.adoption)) },
                    selected = currentRoute == Screen.Adoption.route,
                    onClick = { navController.navigate(Screen.Adoption.route) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Event, contentDescription = null) },
                    label = { Text(stringResource(R.string.events)) },
                    selected = currentRoute == Screen.Events.route,
                    onClick = { navController.navigate(Screen.Events.route) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.DateRange, contentDescription = null) },
                    label = { Text(stringResource(R.string.calendar)) },
                    selected = currentRoute == Screen.Calendar.route,
                    onClick = { navController.navigate(Screen.Calendar.route) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = null) },
                    label = { Text(stringResource(R.string.profile)) },
                    selected = currentRoute == Screen.Profile.route,
                    onClick = { navController.navigate(Screen.Profile.route) }
                )
            }
        }
    ) { paddingValues ->
        NavGraph(
            navController = navController,
            modifier = Modifier.padding(paddingValues)
        )
    }
} 