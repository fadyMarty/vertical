package com.verticalautomotive.android.presentation.onboarding

import androidx.annotation.DrawableRes

data class OnboardingItem(
    @DrawableRes val image: Int,
    val title: String,
    val description: String,
)