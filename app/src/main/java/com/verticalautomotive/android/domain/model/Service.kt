package com.verticalautomotive.android.domain.model

import androidx.annotation.DrawableRes

data class Service(
    val title: String,
    @DrawableRes val icon: Int,
    val price: Int,
    val duration: Int,
)
