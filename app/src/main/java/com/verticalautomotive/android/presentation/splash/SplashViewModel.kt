package com.verticalautomotive.android.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.verticalautomotive.android.domain.repository.SettingsRepository
import com.verticalautomotive.android.presentation.navigation.Route
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow

class SplashViewModel(
    private val settingsRepository: SettingsRepository,
) : ViewModel() {

    private val eventChannel = Channel<SplashEvent>()
    val events = eventChannel.receiveAsFlow()

    init {
        settingsRepository.readOnboardingState()
            .onEach { completed ->
                if (completed) {
                    eventChannel.send(
                        SplashEvent.OnReadOnboardingState(
                            route = Route.HomeGraph.route
                        )
                    )
                } else {
                    eventChannel.send(
                        SplashEvent.OnReadOnboardingState(
                            route = Route.Onboarding.route
                        )
                    )
                }
            }.launchIn(viewModelScope)
    }
}