package com.swarajya.smartexpensetracker.core.domain.usecase

import com.swarajya.smartexpensetracker.core.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IsDarkThemeUseCase @Inject constructor(private val themeRepository: ThemeRepository) {

    operator  fun invoke(): Flow<Boolean?> {
        return themeRepository.isDarkTheme()
    }
}