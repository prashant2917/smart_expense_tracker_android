package com.swarajya.smartexpensetracker.core.di

import com.swarajya.smartexpensetracker.core.data.ThemeManager
import com.swarajya.smartexpensetracker.core.data.repository.ThemeRepositoryImpl
import com.swarajya.smartexpensetracker.core.domain.repository.ThemeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CoreModule {

    @Provides
    @Singleton
    fun provideThemeRepository(themeManager: ThemeManager): ThemeRepository {
        return ThemeRepositoryImpl(themeManager)
    }

}