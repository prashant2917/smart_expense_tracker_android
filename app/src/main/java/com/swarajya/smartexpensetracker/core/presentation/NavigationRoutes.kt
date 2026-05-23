package com.swarajya.smartexpensetracker.core.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

// Define type-safe destinations
@Serializable object Home
@Serializable object Scanner
@Serializable object Analytics
@Serializable object Settings

data class TopLevelRoute<T : Any>(
    val name: String,
    val route: T,
    val icon: ImageVector
)

val TOP_LEVEL_ROUTES = listOf(
    TopLevelRoute("Home", Home, Icons.Filled.Home),
    TopLevelRoute("Scanner", Scanner, Icons.Filled.QrCodeScanner),
    TopLevelRoute("Analytics", Analytics, Icons.Filled.Analytics),
    TopLevelRoute("Settings", Settings, Icons.Filled.Settings)
)
