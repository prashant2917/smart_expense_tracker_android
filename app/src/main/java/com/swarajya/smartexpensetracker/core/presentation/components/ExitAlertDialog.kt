package com.swarajya.smartexpensetracker.core.presentation.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.swarajya.smartexpensetracker.R

@Composable
fun ExitAlertDialog(onYesClick: () -> Unit = {}, onNoClick: () -> Unit = {}) {
    AlertDialog(
        onDismissRequest = { onNoClick() },
        title = { Text(text = stringResource(id = R.string.exit_dialog_title)) },
        text = { Text(text = stringResource(id = R.string.exit_dialog_message)) },
        confirmButton = {
            TextButton(onClick = {
                // Finish the activity and remove task
                onYesClick()
            }) {
                Text(text = stringResource(id = R.string.yes))
            }
        },
        dismissButton = {
            TextButton(onClick = { onNoClick() }) {
                Text(text = stringResource(id = R.string.no))
            }
        },
    )
}