package com.swarajya.smartexpensetracker.core.presentation

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
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.swarajya.smartexpensetracker.core.presentation.components.SmartExpenseTrackerBottomBar
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

    Scaffold(
        modifier = Modifier.fillMaxSize(),
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
}