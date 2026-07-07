package com.swarajya.smartexpensetracker.core.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import com.swarajya.smartexpensetracker.R
import com.swarajya.smartexpensetracker.core.presentation.Analytics
import com.swarajya.smartexpensetracker.core.presentation.Home
import com.swarajya.smartexpensetracker.core.presentation.Scanner
import com.swarajya.smartexpensetracker.core.presentation.Settings

@Composable
fun NavDestination?.getAppTopBarTitle(): String? {
    return when {
        this?.hierarchy?.any { it.hasRoute(Home::class) } == true ->
            stringResource(R.string.dashboard)

        this?.hierarchy?.any { it.hasRoute(Scanner::class) } == true ->
            stringResource(R.string.scanner)

        this?.hierarchy?.any { it.hasRoute(Analytics::class) } == true ->
            stringResource(R.string.analytics)

        this?.hierarchy?.any { it.hasRoute(Settings::class) } == true ->
            stringResource(R.string.settings)

        else -> stringResource(R.string.app_name)
    }
}