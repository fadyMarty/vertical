package com.verticalautomotive.android.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.verticalautomotive.android.domain.repository.SettingsRepository
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val settingsRepository: SettingsRepository,
) : ViewModel() {

    fun onEvent(event: OnboardingEvent) {
        when (event) {
            OnboardingEvent.OnSkipClick -> {
                viewModelScope.launch {
                    settingsRepository.saveOnboardingState(completed = true)
                }
            }
        }
    }
}