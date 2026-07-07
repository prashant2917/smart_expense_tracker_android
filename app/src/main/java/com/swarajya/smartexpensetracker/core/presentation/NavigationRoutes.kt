package com.swarajya.smartexpensetracker.core.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

// Define type-safe destinations
@Serializable
object Home
@Serializable
object Scanner
@Serializable
object Analytics
@Serializable
object Settings

data class BottomBarRoute<T : Any>(
    val name: String,
    val route: T,
    val icon: ImageVector
)

val BOTTOM_BAR_ROUTES = listOf(
    BottomBarRoute(BottomBarRouteNames.HOME, Home, Icons.Filled.Home),
    BottomBarRoute(BottomBarRouteNames.SCANNER, Scanner, Icons.Filled.QrCodeScanner),
    BottomBarRoute(BottomBarRouteNames.ANALYTICS, Analytics, Icons.Filled.Analytics),
    BottomBarRoute(BottomBarRouteNames.SETTINGS, Settings, Icons.Filled.Settings)
)

object BottomBarRouteNames {
    const val HOME = "Home"
    const val SCANNER = "Scanner"
    const val ANALYTICS = "Analytics"
    const val SETTINGS = "Settings"
}
