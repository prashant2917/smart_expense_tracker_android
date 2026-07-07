package com.swarajya.smartexpensetracker.core.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.swarajya.smartexpensetracker.core.presentation.BOTTOM_BAR_ROUTES

@Composable
fun SmartExpenseTrackerBottomBar(
    navController: NavHostController,
    currentDestination: NavDestination?
) {
    NavigationBar {
        BOTTOM_BAR_ROUTES.forEach { bottomBarRoute ->
            val isSelected = currentDestination?.hierarchy?.any {
                it.hasRoute(bottomBarRoute.route::class)
            } == true

            NavigationBarItem(
                icon = { Icon(bottomBarRoute.icon, contentDescription = bottomBarRoute.name) },
                label = { Text(bottomBarRoute.name) },
                selected = isSelected,
                onClick = {
                    navController.navigate(bottomBarRoute.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true

                        }

                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}