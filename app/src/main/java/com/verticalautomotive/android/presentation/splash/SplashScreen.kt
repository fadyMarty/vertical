package com.verticalautomotive.android.presentation.splash

import androidx.compose.runtime.Composable
import com.verticalautomotive.android.common.util.ObserveAsEvents
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashRoot(
    viewModel: SplashViewModel = koinViewModel(),
    onReadOnboardingState: (String) -> Unit,
) {
    ObserveAsEvents(viewModel.events) { event ->
        when (event) {
            is SplashEvent.OnReadOnboardingState -> {
                onReadOnboardingState(event.route)
            }
        }
    }
}