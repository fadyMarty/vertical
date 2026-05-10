package com.verticalautomotive.android.presentation.home

import com.verticalautomotive.android.R
import com.verticalautomotive.android.domain.model.Service

data class HomeState(
    val services: List<Service> = listOf(
        Service(
            title = "Brakes and rotors",
            icon = R.drawable.img_brakes_service,
            price = 100,
            duration = 2
        ),
        Service(
            title = "Engine, oil and filters",
            icon = R.drawable.img_engine_service,
            price = 100,
            duration = 2
        ),
        Service(
            title = "Battery, start and charge systems",
            icon = R.drawable.img_battery_service,
            price = 100,
            duration = 2
        ),
        Service(
            title = "Full diagnosis of the problem",
            icon = R.drawable.img_diagnosis_service,
            price = 100,
            duration = 2
        )
    ),
)
