package com.swarajya.smartexpensetracker.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swarajya.smartexpensetracker.core.domain.usecase.IsDarkThemeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoreViewModel @Inject constructor(private val isDarkThemeUseCase : IsDarkThemeUseCase) : ViewModel() {

    private val _isDarkThemeFlow = MutableStateFlow<Boolean?>(null)
    val isDarkThemeFlow = _isDarkThemeFlow.asStateFlow()

    init {
        isDarkTheme()
    }

    fun isDarkTheme() {
        viewModelScope.launch(Dispatchers.IO) {
            isDarkThemeUseCase().collect {
                _isDarkThemeFlow.value = it
            }
        }
    }
}
