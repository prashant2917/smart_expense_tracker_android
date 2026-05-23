package com.swarajya.smartexpensetracker.core.domain.repository

import kotlinx.coroutines.flow.Flow

interface ThemeRepository {

    fun setTheme(isDark: Boolean)

    fun isDarkTheme() : Flow<Boolean?>
}