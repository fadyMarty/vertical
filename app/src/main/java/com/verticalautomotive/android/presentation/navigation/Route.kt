package com.verticalautomotive.android.presentation.navigation

sealed class Route(val route: String) {
    data object Splash : Route("splash")
    data object Onboarding : Route("onboarding")
    data object AuthGraph : Route("auth_graph")
    data object Welcome : Route("welcome")
    data object PhoneLoginGraph : Route("phone_login_graph")
    data object PhoneLogin : Route("phone_login")
    data object PhoneConfirmation : Route("phone_confirmation")
    data object EmailLogin : Route("email_login")
    data object HomeGraph : Route("home_graph")
    data object Home : Route("home")
    data object Services : Route("services")
    data object Garage : Route("garage")
    data object Chat : Route("chat")
    data object PromotionList : Route("promotion_list")
    data object ChatList : Route("chat_list")
    data object ChatDetail : Route("chat_detail")
}