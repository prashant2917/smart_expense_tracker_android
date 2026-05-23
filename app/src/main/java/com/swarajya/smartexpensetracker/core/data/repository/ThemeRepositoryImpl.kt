package com.swarajya.smartexpensetracker.core.data.repository

import com.swarajya.smartexpensetracker.core.data.ThemeManager
import com.swarajya.smartexpensetracker.core.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ThemeRepositoryImpl @Inject constructor(private val themeManager: ThemeManager) :
    ThemeRepository {

    override fun setTheme(isDark: Boolean) {
     themeManager.setTheme(isDark)
    }

    override fun isDarkTheme(): Flow<Boolean?> {
      return themeManager.isDarkTheme()
    }


}