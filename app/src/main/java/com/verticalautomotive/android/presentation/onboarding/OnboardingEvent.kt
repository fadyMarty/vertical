package com.verticalautomotive.android.presentation.onboarding

sealed interface OnboardingEvent {
    data object OnSkipClick : OnboardingEvent
}