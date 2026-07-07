package com.swarajya.smartexpensetracker.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.swarajya.smartexpensetracker.R
import com.swarajya.smartexpensetracker.core.data.FontSizeConstants
import com.swarajya.smartexpensetracker.core.presentation.AppTypography

@Composable
fun EmptyHomeScreen() {
    Column {
        Text(
            text = stringResource(R.string.scan_bills_message),
            fontSize = FontSizeConstants.FONT_SIZE_16_SP,
            fontFamily = AppTypography.bodyMedium.fontFamily,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )
    }
}