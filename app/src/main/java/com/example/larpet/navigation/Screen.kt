package com.example.larpet.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Adoption : Screen("adoption")
    object Events : Screen("events")
    object Calendar : Screen("calendar")
    object Profile : Screen("profile")
} 