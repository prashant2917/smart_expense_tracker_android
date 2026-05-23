package com.swarajya.smartexpensetracker.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.swarajya.smartexpensetracker.analytics.presentation.AnalyticsScreen
import com.swarajya.smartexpensetracker.home.presentation.HomeScreen
import com.swarajya.smartexpensetracker.scanner.presentation.ScannerScreen
import com.swarajya.smartexpensetracker.settings.presentation.SettingsScreen

@Composable
fun AppNavigationController(modifier : Modifier = Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Home,
        modifier = modifier

    ) {
        composable<Home> { HomeScreen() }
        composable<Scanner> { ScannerScreen() }
        composable<Analytics> { AnalyticsScreen() }
        composable<Settings> { SettingsScreen() }
    }
}