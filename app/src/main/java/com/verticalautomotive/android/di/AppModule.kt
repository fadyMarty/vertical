package com.verticalautomotive.android.di

import com.verticalautomotive.android.data.repository.ChatRepositoryImpl
import com.verticalautomotive.android.data.repository.SettingsRepositoryImpl
import com.verticalautomotive.android.domain.repository.ChatRepository
import com.verticalautomotive.android.domain.repository.SettingsRepository
import com.verticalautomotive.android.domain.use_case.ValidateEmailUseCase
import com.verticalautomotive.android.presentation.chat_detail.ChatDetailViewModel
import com.verticalautomotive.android.presentation.chat_list.ChatListViewModel
import com.verticalautomotive.android.presentation.email_login.EmailLoginViewModel
import com.verticalautomotive.android.presentation.home.HomeViewModel
import com.verticalautomotive.android.presentation.onboarding.OnboardingViewModel
import com.verticalautomotive.android.presentation.phone_login.PhoneLoginViewModel
import com.verticalautomotive.android.presentation.splash.SplashViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    singleOf(::SettingsRepositoryImpl).bind<SettingsRepository>()
    singleOf(::ChatRepositoryImpl).bind<ChatRepository>()

    factoryOf(::ValidateEmailUseCase)

    viewModelOf(::SplashViewModel)
    viewModelOf(::OnboardingViewModel)

    viewModelOf(::PhoneLoginViewModel)
    viewModelOf(::EmailLoginViewModel)

    viewModelOf(::HomeViewModel)
    viewModelOf(::ChatListViewModel)
    viewModelOf(::ChatDetailViewModel)
}