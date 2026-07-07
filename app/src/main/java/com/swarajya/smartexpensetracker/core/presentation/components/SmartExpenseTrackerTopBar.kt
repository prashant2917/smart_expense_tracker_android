package com.swarajya.smartexpensetracker.core.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavDestination
import com.swarajya.smartexpensetracker.R
import com.swarajya.smartexpensetracker.core.data.getAppTopBarTitle
import com.swarajya.smartexpensetracker.core.presentation.AppTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmartExpenseTrackerTopBar(currentDestination: NavDestination?, onBackClick: () -> Unit = {}) {
    val appBarTitle = currentDestination.getAppTopBarTitle() ?: stringResource(R.string.app_name)
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = appBarTitle,
                fontWeight = FontWeight.Bold,
                style = AppTypography.titleMedium
            )

        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),

        navigationIcon = {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        }
    )
}
