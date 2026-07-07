package com.swarajya.smartexpensetracker.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.swarajya.smartexpensetracker.R
import com.swarajya.smartexpensetracker.core.data.DimensionConstants
import com.swarajya.smartexpensetracker.home.presentation.components.EmptyHomeScreen

@Composable
fun HomeScreen() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // TODO: navigate to scanner or start scanning
            }) {
                Icon(
                    imageVector = Icons.Filled.QrCodeScanner,
                    contentDescription = stringResource(R.string.scanner)
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(DimensionConstants.DIMENS_16_DP)
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            EmptyHomeScreen()
        }
    }
}