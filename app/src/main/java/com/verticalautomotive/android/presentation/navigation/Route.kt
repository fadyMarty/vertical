package com.verticalautomotive.android.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object AuthGraph : Route

    @Serializable
    data object Welcome : Route

    @Serializable
    data object PhoneLoginGraph : Route

    @Serializable
    data object PhoneLogin : Route

    @Serializable
    data object PhoneConfirmation : Route

    @Serializable
    data object EmailLogin : Route

    @Serializable
    data object HomeGraph : Route

    @Serializable
    data object Home : Route

    @Serializable
    data object Services : Route

    @Serializable
    data object Garage : Route

    @Serializable
    data object Chat : Route

    @Serializable
    data object PromotionList : Route

    @Serializable
    data object ChatList : Route

    @Serializable
    data class ChatDetail(val id: String) : Route
}