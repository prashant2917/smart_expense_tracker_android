package com.swarajya.smartexpensetracker.core.presentation

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.swarajya.smartexpensetracker.core.presentation.components.ExitAlertDialog
import com.swarajya.smartexpensetracker.core.presentation.components.SmartExpenseTrackerBottomBar
import com.swarajya.smartexpensetracker.core.presentation.components.SmartExpenseTrackerTopBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val coreViewModel: CoreViewModel = hiltViewModel()
            val themePreference by coreViewModel.isDarkThemeFlow.collectAsStateWithLifecycle()
            val isDarkTheme = themePreference ?: isSystemInDarkTheme()
            SmartTrackerAppTheme(darkTheme = isDarkTheme) {
                SmartExpenseTrackerApp()
            }
        }
    }

}

@Composable
fun SmartExpenseTrackerApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    // State for exit confirmation dialog
    var showExitDialog by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current
    val activity = context as? Activity

    val isHome = currentDestination?.hierarchy?.any {
        it.hasRoute(Home::class)
    } == true

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SmartExpenseTrackerTopBar(currentDestination = currentDestination, onBackClick = {
                if (isHome) {
                    showExitDialog = true
                } else {
                    navController.navigateUp()
                }
            })
        },
        bottomBar = {
            SmartExpenseTrackerBottomBar(
                navController = navController,
                currentDestination = currentDestination
            )
        }
    ) { innerPadding ->
        AppNavigationController(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }

    if (showExitDialog) {
        ExitAlertDialog(
            onYesClick = {
                activity?.finishAffinity()
                showExitDialog = false
            },
            onNoClick = { showExitDialog = false })
    }
}